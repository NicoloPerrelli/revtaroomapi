package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Principal;
import com.revature.entities.Housing;
import com.revature.exceptions.BadRequestException;
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
	public Housing postHouses(@RequestBody Housing housing, HttpServletRequest req) {
		System.out.println("In postHouses controller...");
//		Principal principal = (Principal) req.getAttribute("principal");
		System.out.println("Housing " + housing.toString() );
		return this.housingService.addHousing(housing);
	}
	
	
	
}
