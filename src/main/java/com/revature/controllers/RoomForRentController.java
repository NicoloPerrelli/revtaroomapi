package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.BrokenHousing;
import com.revature.dtos.Principal;
import com.revature.entities.Housing;
import com.revature.entities.RoomForRent;
import com.revature.entities.User;
import com.revature.exceptions.BadRequestException;
import com.revature.services.RoomForRentService;

@RestController
@RequestMapping("/rent")
public class RoomForRentController {

	private RoomForRentService rfrService;

	@Autowired
	public RoomForRentController(RoomForRentService service) {
		this.rfrService = service;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RoomForRent addRoom(@RequestBody BrokenHousing bh, HttpServletRequest req) {

		System.out.println("Brokenhouse" + bh);
		Principal principal = (Principal) req.getAttribute("principal");

		if (principal == null || principal.getId() <= 0)
			throw new BadRequestException("Unauthorized");
	
		System.out.println("After principal");
		bh.setUserId(principal.getId());
		System.out.println("Principal Id: " + principal.getId());
		System.out.println("Principal: " + principal.getEmail());
		return this.rfrService.roomForRent(bh);
	}
}
