package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Principal;
import com.revature.entities.UserProfile;
import com.revature.exceptions.ErrorResponse;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.services.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	private ProfileService profileService;

	@Autowired
	public ProfileController(ProfileService service) {
		this.profileService = service;
	}
	

	@GetMapping(produces="application/json")
	public UserProfile getMyProfile(HttpServletRequest req){
		Principal principal = (Principal) req.getAttribute("principal");
		return profileService.getById(principal.getId());
	}
	

	@PostMapping(produces="application/json", consumes="application/json")
	public boolean updateProfile(@RequestHeader("principal") int id, @RequestBody UserProfile upadatedProfile){
		return profileService.updateProfile(upadatedProfile);
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
