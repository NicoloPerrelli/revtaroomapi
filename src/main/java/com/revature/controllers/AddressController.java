package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Address;
import com.revature.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	private AddressService addrService;
	
	@Autowired
	public AddressController(AddressService service) {
		this.addrService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Address> getHouses() {
		
		return addrService.getAllAdresses();
	}
	
}
