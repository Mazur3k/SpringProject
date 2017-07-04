package org.edu.mazurek.edu.controllers;

import java.util.ArrayList;
import java.util.List;

import org.edu.mazurek.edu.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	List<User> users = new ArrayList<>();
	
	
	@RequestMapping("/")
	public String index()
	{
		return "Hello Everyone!";
	}
	
	@RequestMapping("/users")
	public List addUsers()
	{
		users.add(new User("Adam","Mazurkiewicz","adam.mazurkiewicz92@gmail.com",24));
		users.add(new User("Jan","Kowalski","jan.kowalski@gmail.com",21));
		users.add(new User("Stefan","Niesiolowski","stefan.niesiolowski@gmail.com",64));
		users.add(new User("Eugeniusz","Smolarek","eugeniusz.smolarek@gmail.com",36));
		
		return users;
	}
}



