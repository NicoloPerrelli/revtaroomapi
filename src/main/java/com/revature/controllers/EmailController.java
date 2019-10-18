package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Principal;
import com.revature.entities.EmailPackage;
import com.revature.entities.User;
import com.revature.exceptions.BadRequestException;
import com.revature.exceptions.ErrorResponse;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.services.EmailService;
import com.revature.services.UserServices;

@RestController
@RequestMapping("/email")
public class EmailController {

	private UserServices userServices;
	private EmailService emailService;
	
	@Autowired
	public EmailController(EmailService emailService, UserServices userServices) {
		this.emailService = emailService;
		this.userServices = userServices;
	}
	

	@PostMapping(consumes="application/json")
	public boolean sendEmail(HttpServletRequest req, @RequestBody EmailPackage email){
		Principal principal = (Principal) req.getAttribute("principal");
		User userFromPrincipal = userServices.getUserById(principal.getId());
		
		if(userFromPrincipal.getEmail() != email.getEmail()) { throw new BadRequestException("email sent with user.eamil that doent match users account"); }
		
		return emailService.sendEmail(email);
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
