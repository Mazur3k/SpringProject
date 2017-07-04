package org.edu.mazurek.edu.model;

import java.util.ArrayList;
import java.util.List;

public class User {	
	private String firstname;
	private String lastname;	
	private String email;
	private int age;
	
	public User (String firstname, String lastname, String email, int age)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
	}
	
	public String getFirstName()
	{
		return firstname;
	}
	
	public String getLastName()
	{
		return lastname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return "Imie: "+firstname+" Nazwisko: "+lastname+" email: "+email+" Wiek: "+Integer.toString(age);
	}
	
}
