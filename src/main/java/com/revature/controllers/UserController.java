package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.User;
import com.revature.exceptions.ErrorResponse;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserServices userService;
	
	@Autowired
	public UserController(UserServices service) {
		this.userService = service;
	}
	
	@GetMapping(produces="application/json")
	public List<User> getAllUsers(){
		
		return userService.getAll();
	}
	
	@ResponseStatus( HttpStatus.CREATED)
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User newUser) {
		return this.userService.register(newUser);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException rnfe) {
		ErrorResponse err = new ErrorResponse();
		err.setStatus(404);
		err.setMessage(rnfe.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		return err;
	}
}
