package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dtos.BrokenHousing;
import com.revature.entities.Housing;
import com.revature.entities.RoomAvailabiltyStatus;
import com.revature.entities.RoomForRent;
import com.revature.exceptions.ResourceCreationException;
import com.revature.repos.HousingRepo;
import com.revature.repos.RoomForRentRepository;

@Service
public class RoomForRentService {
	
	private RoomForRentRepository roomRepo;
	private HousingService housingService;
	
	@Autowired
	public RoomForRentService(RoomForRentRepository rfr, HousingService housing) {
		this.roomRepo = rfr;
		this.housingService = housing;
	}
	
	@Transactional
	public RoomForRent roomForRent(BrokenHousing bh) {
		
		
//		if(!validateFields(roomForRent)) {
//			
//			throw new ResourceCreationException("Invalid input values were detected");
//		}
		System.out.println(bh);
		RoomForRent rent = new RoomForRent();
		Housing housing = housingService.addHousing(bh);
		System.out.println(housing);
		
		rent.setHouse(housing);
		System.out.println(rent);
		rent.setPricePerMonth(housing.getPricePerMonth());
		//Set the availablity status to yes 
		rent.setStatus(new RoomAvailabiltyStatus("YES"));
		
		return roomRepo.save(rent);
	}
	
	
	public boolean validateFields(RoomForRent room) {
		
		if(room.getPricePerMonth() <= 0) return false;
		if(room.getHouse() ==  null) return false;
		
		return true;
	}

}
