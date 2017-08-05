package org.edu.mazurek.edu.controllers;

import org.edu.mazurek.edu.form.AddUserForm;
import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
/*        if(bindingResult.hasErrors()){
            throw new BindingResultException();
        }*/
        Map<String, String> map = new HashMap<>();
        User user = new User(0l, addUserForm.getFirstname(), addUserForm.getLastname(), addUserForm.getEmail(),
                addUserForm.getBirthdate(), addUserForm.getPassword());

        userRepository.save(user);
        map.put("success", "");

        return new ModelAndView("Home", map);
    }

    @RequestMapping("get")
    public Iterable<User> getUsers() {

        Iterable<User> all = userRepository.findAll();
        return all;
    }


    @RequestMapping("findByFirstName/{firstname}")
    public Iterable<User> getByFirstName(@PathVariable String firstname) {
        return userRepository.findByFirstnameIgnoreCase(firstname);
    }

    @RequestMapping("findByEmail/{email}")
    public Iterable<User> getByEmail(@PathVariable String email) {
        return userRepository.findByEmailContainingIgnoreCase(email);
    }

}



