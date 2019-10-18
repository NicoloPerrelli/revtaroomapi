package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Principal;
import com.revature.entities.User;
import com.revature.entities.UserProfile;
import com.revature.exceptions.ErrorResponse;
import com.revature.exceptions.ResourceCreationException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.services.ProfileService;
import com.revature.services.UserServices;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	private static Logger log = LogManager.getLogger(ProfileController.class);
	private UserServices userServices;
	private ProfileService profileService;

	@Autowired
	public ProfileController(UserServices userServices, ProfileService profileService) {
		this.userServices = userServices;
		this.profileService = profileService;
	}
	

	@GetMapping(produces="application/json")
	public User getMyProfile(HttpServletRequest req){
		System.out.println("in getMyProfile in profileController... " + req);

		Principal principal = (Principal) req.getAttribute("principal");
		return userServices.getUserById(principal.getId());
	}
	
	@PutMapping(produces="application/json", consumes="application/json")
	public boolean updateProfile(HttpServletRequest req, @RequestBody UserProfile upadatedProfile){
		System.out.println("Before principal we have this - "+upadatedProfile);
		Principal principal = (Principal) req.getAttribute("principal");
		int proId = userServices.getUserById(principal.getId()).getProfile().getId();
		System.out.println("the user id from jwt " + proId);
		return profileService.updateProfile(proId,upadatedProfile);
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
