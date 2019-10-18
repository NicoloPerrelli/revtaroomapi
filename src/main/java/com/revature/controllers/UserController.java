package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.User;
import com.revature.exceptions.ErrorResponse;
import com.revature.exceptions.ResourceCreationException;
import com.revature.security.Secured;
import com.revature.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserServices userService;
	
	
	@Autowired
	public UserController(UserServices service) {
		this.userService = service;
		
	}
	
	@Secured(allowedRoles = { "ADMIN", "DEV" })
	@GetMapping(produces="application/json")
	public List<User> getAllUsers(){
		
		return userService.getAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="/{id}", produces="application/json")
	public User getCardById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@ResponseStatus( HttpStatus.CREATED)
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User newUser) {
		return this.userService.register(newUser);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PatchMapping(produces="application/json", consumes="application/json")
	public void updateUser(@RequestBody User updatedUser) {
		userService.updateUser(updatedUser);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleResourceNotFoundException(ResourceCreationException rnfe) {
		ErrorResponse err = new ErrorResponse();
		err.setStatus(409);
		err.setMessage(rnfe.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		return err;
	}
	
	
}
