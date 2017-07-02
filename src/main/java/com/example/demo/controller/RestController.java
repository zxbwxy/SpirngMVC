package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all-users")
	public String allUsers(){
		return userService.findAll().toString();
		
	}

	@GetMapping("/save-user")
	public String saveUser(@RequestParam String name, @RequestParam String password, @RequestParam String email, @RequestParam String role){
		User user = new User(name, password, email, new Date(), role);
		userService.save(user);
		return "User saved!";
	}
	
	@GetMapping("/delete-user")
	public String saveUser(@RequestParam int id){
		userService.delete(id);
		return "User deleted!";
	}
	
	@ModelAttribute("users")
	public List<User> users(){
		 return userService.findAll();
	}
	
}
