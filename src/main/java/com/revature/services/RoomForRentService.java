package com.revature.services;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dtos.BrokenHousing;
import com.revature.entities.Housing;
import com.revature.entities.RoomAvailabiltyStatus;
import com.revature.entities.RoomForRent;
import com.revature.exceptions.BadRequestException;
import com.revature.exceptions.ResourceCreationException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.repos.RoomForRentRepository;

@Service
public class RoomForRentService {
	
	private static Logger log = LogManager.getLogger(RoomForRent.class);
	
	private RoomForRentRepository roomRepo;
	private HousingService housingService;
	
	@Autowired
	public RoomForRentService(RoomForRentRepository rfr, HousingService housing) {
		this.roomRepo = rfr;
		this.housingService = housing;
	}
	
	@Transactional
	public RoomForRent roomForRent(BrokenHousing bh) {
		log.info("roomRepo.roomForRent invocked!");
		
		if(bh == null) {
			
			throw new ResourceCreationException("Invalid input values were detected");
		}
		RoomForRent rent = new RoomForRent();
		Housing housing = housingService.addHousing(bh);
		
		rent.setHouse(housing);
		rent.setPricePerMonth(housing.getPricePerMonth());
		
		log.info("Set the availablity status to yes");
		rent.setStatus(new RoomAvailabiltyStatus("YES"));
		roomRepo.save(rent);
		
		System.out.println(rent);
		return rent;
	}
	
	@Transactional
	public List<RoomForRent> getRoomByUserId(int id) {
		log.info("roomRepo.getRoomByUserId invoked");
		if (id <= 0) {
			throw new BadRequestException("Invalid id provided");
		}
		
		if (roomRepo.getRoomByUserId(id) == null) {

			throw new ResourceNotFoundException("No user found with provided id");
		}
		return roomRepo.getRoomByUserId(id);
	}
	
	@Transactional
	public List<RoomForRent> getAllAvailableRoom(){
		log.info("roomRepo.getAllAvailableRoom invocked!");
		
		return roomRepo.getAll();
	}
	
	@Transactional
	public boolean updateRoomStatus(RoomForRent updateRoom) {
		log.info("roomRepo.updateRoomStatus invocked!");
		
		return roomRepo.update(updateRoom);
	}
	
	
	public boolean validateFields(RoomForRent room) {
		log.info("roomRepo.validateFields");
		
		if(room.getPricePerMonth() <= 0) return false;
		if(room.getHouse() ==  null) return false;
		
		return true;
	}

}
