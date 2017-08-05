package org.edu.mazurek.edu.controllers;

import org.edu.mazurek.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView Home() {
        HashMap<String, String> params = new HashMap<>();
        return new ModelAndView("Home", params);
    }

    @RequestMapping("/signup")
    public String signUp() {

        return "Signup";
    }

    @RequestMapping("/news")
    public String news() {

        return "News";
    }


}
