package org.edu.mazurek.edu.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.edu.mazurek.edu.form.AddUserForm;
import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.model.UserCourse;
import org.edu.mazurek.edu.repository.CourseRepository;
import org.edu.mazurek.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    private CourseRepository courseRepository;

    @Autowired
    private ICaptchaService captchaService;

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
    public ModelAndView addUsers(@Valid AddUserForm addUserForm, HttpServletRequest request) {

        Map<String, String> map = new HashMap<>();
        if (userRepository.findByEmailContainingIgnoreCase(addUserForm.getEmail()).isEmpty()) {
            User user = new User(0l, addUserForm.getFirstname(), addUserForm.getLastname(), addUserForm.getEmail(),
                    addUserForm.getBirthdate(), addUserForm.getPassword(), addUserForm.getUserCourseList());

            userRepository.save(user);
            map.put("success", "");

            String response = request.getParameter("g-recaptcha-response");
            captchaService.processResponse(response);

            return new ModelAndView("Home", map);
        } else {
            map.put("errorEmail", "");
            return new ModelAndView("signup", map);
        }
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

    @RequestMapping(method = RequestMethod.GET, path="delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long userId)
    {
        Map<String,String> map = new HashMap<>();
        userRepository.delete(userId);
        map.put("successDelete","");
        return new ModelAndView("panel",map);
    }

    @RequestMapping(method = RequestMethod.GET, path="update_form/{id}")
    public ModelAndView updateForm(@PathVariable("id") Long id/*, @ModelAttribute("user") User user*/)
    {
        Map<String, Object> map = new HashMap<>();
        User existingUser = userRepository.findOne(id);
        map.put("showForm","");
        map.put("user",existingUser);
        return new ModelAndView("panel", map);

    }

    @RequestMapping(method = RequestMethod.POST, path="update/{id}")
    public ModelAndView updateUser(@PathVariable("id") Long id, @Valid AddUserForm addUserForm)
    {
        Map<String, String> map = new HashMap<>();
        User existingUser = userRepository.findOne(id);
        existingUser.setFirstname(addUserForm.getFirstname());
        existingUser.setLastname(addUserForm.getLastname());
        existingUser.setEmail(addUserForm.getEmail());
        existingUser.setBirthdate(addUserForm.getBirthdate());
        existingUser.setPassword(addUserForm.getPassword());
        userRepository.save(existingUser);
        map.put("userUpdated","");
        return new ModelAndView("panel", map);
    }

    @RequestMapping("addStudentCourse")
    public ModelAndView addStudentToCourse()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("showSelectBars","");
        map.put("students",userRepository.findAll());
        map.put("courses",courseRepository.findAll());
        return new ModelAndView("studentzone", map);
    }

}



