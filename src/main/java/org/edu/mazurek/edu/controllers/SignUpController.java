package org.edu.mazurek.edu.controllers;

import org.edu.mazurek.edu.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

	@RequestMapping("/signup")
	public String signUp() {

        return "Signup";
	}

}