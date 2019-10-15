package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.BrokenHousing;
import com.revature.dtos.Principal;
import com.revature.entities.Housing;
import com.revature.exceptions.BadRequestException;
import com.revature.exceptions.ErrorResponse;
import com.revature.exceptions.ResourceCreationException;
import com.revature.services.HousingService;
import com.revature.util.GenericValidation;

@RestController
@RequestMapping("/housing")
public class HousingController {
	
	private HousingService housingService;
	
	@Autowired
	public HousingController(HousingService service) {
		this.housingService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Housing> getHouses(@RequestParam(required = false) String id) {
		System.out.println("Id: "+ id);
		
		if(id != null) {
			if(GenericValidation.isNumber(id)) {
				return housingService.getHousingById(Integer.parseInt(id));
			}
			else {
				throw new BadRequestException("Invalid param.");
			}
		}
		
		return housingService.getAllHousing();
	}
	
	@PostMapping(produces="application/json")
	public Housing postHouses(@RequestBody BrokenHousing bh, HttpServletRequest req) throws BadRequestException {
		System.out.println("In postHouses controller...");
		Principal principal = (Principal) req.getAttribute("principal");
		
		if(principal == null || principal.getId() == 0) throw new BadRequestException("Unauthorized");
		
		bh.setUserId(principal.getId());
		System.out.println("Principal: " + principal.getEmail());
		
		// Validation of Address
		// to do
		
		// Validation of PricePerMonth
		if(bh.getPricePerMonth() < 100 || bh.getPricePerMonth() > 5000) throw new BadRequestException("Invalid price");
		
		
		return this.housingService.addHousing(bh);
	}
	
	@ExceptionHandler
	public ErrorResponse handleResourceNotFoundException(BadRequestException bre) {
		
		return bre.getError();
	}
	
}
