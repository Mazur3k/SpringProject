package org.edu.mazurek.edu.controllers;

import org.edu.mazurek.edu.form.AddUserForm;
import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.model.UserCourse;
import org.edu.mazurek.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

//    @RequestMapping("add")
//    public String addUsers(@Valid AddUserForm addUserForm) {
///*        if(bindingResult.hasErrors()){
//            throw new BindingResultException();
//        }*/
//        User user = new User(0l, addUserForm.getFirstname(), addUserForm.getLastname(), addUserForm.getEmail(),
//                addUserForm.getBirthdate(), addUserForm.getPassword());
//
//        userRepository.save(user);
//
//        return "User has been added: " + user;


//    }

    @RequestMapping("add")
    public ModelAndView addUsers(@Valid AddUserForm addUserForm) {

        Map<String, String> map = new HashMap<>();
        User user = new User(0l, addUserForm.getFirstname(), addUserForm.getLastname(), addUserForm.getEmail(),
                addUserForm.getBirthdate(), addUserForm.getPassword(),addUserForm.getUserCourseList());

        userRepository.save(user);
        map.put("success", "");

        return new ModelAndView("Home", map);
    }

    @RequestMapping("get")
    public Iterable<User> getUsers() {

        Iterable<User> all = userRepository.findAll();
        return all;
    }

    @RequestMapping("show_users")
    public ModelAndView showUsers(@ModelAttribute("user") User user)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("showUsers","");
        map.put("userList", userRepository.findAll());
        return new ModelAndView("panel",map);
    }


    @RequestMapping("findByFirstName/{firstname}")
    public Iterable<User> getByFirstName(@PathVariable String firstname) {
        return userRepository.findByFirstnameIgnoreCase(firstname);
    }

    @RequestMapping("findByEmail/{email}")
    public Iterable<User> getByEmail(@PathVariable String email) {
        return userRepository.findByEmailContainingIgnoreCase(email);
    }

    @RequestMapping(method= RequestMethod.GET, path="delete/{id}")
    public String deleteUser(@PathVariable("id") Long userId)
    {
        userRepository.delete(userId);
        return "panel";
    }

}



