package org.edu.mazurek.edu.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {


    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/")
    public String index() {
        return "Hello Everyone!";
    }

    @RequestMapping("add")
    public String addUsers(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String birthdate) {

        User user = new User(0l, firstname, lastname, email, birthdate);
        userRepository.save(user);

        return "User has been added: " + user;
    }

    @RequestMapping("get")
    public Iterable<User> getUsers() {

        Iterable<User> all = userRepository.findAll();
        return all;
    }


    @RequestMapping("findByFirstName/{firstname}")
    public Iterable<User> getByFirstName(@PathVariable String firstname){
        return userRepository.findByFirstnameIgnoreCase(firstname);
    }

    @RequestMapping("findByEmail/{email}")
    public Iterable<User> getByEmail(@PathVariable String email){
        return userRepository.findByEmailContainingIgnoreCase(email);
    }

}



