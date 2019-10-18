package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dtos.BrokenHousing;
import com.revature.entities.Address;
import com.revature.entities.Housing;
import com.revature.entities.User;
import com.revature.exceptions.BadRequestException;
import com.revature.filters.AuthFilter;
import com.revature.repos.AddressRepository;
import com.revature.repos.HousingRepo;
import com.revature.repos.UserRepository;

@Service
public class HousingService {
	
	private static Logger log = LogManager.getLogger(HousingService.class); 
	
	private HousingRepo housingRepo;
	private AddressRepository addrRepo;
	private UserRepository userRepo;
	
	@Autowired
	public HousingService(HousingRepo repo, AddressRepository addrRepo, UserRepository userRepo) {
		this.housingRepo = repo;
		this.addrRepo = addrRepo;
		this.userRepo = userRepo;
	}
	
	@Transactional()
	public List<Housing> getAllHousing() {
		return housingRepo.getAll();
	}
	
	@Transactional()
	public List<Housing> getHousingById(int id) {
		List<Housing> list = new ArrayList<>();
		Housing housing = housingRepo.getById(id);
		if(housing != null) list.add(housing);
		return list;
	}
	
	@Transactional()
	public Housing addHousing(BrokenHousing bh) {
		log.info("In service addHousing...");
		
		
		log.info("Validation of PricePerMonth");
		if(bh.getPricePerMonth() < 100 || bh.getPricePerMonth() > 7000) throw new BadRequestException("Invalid price");
		
		
		
		User user = userRepo.getById(bh.getUserId());
		
		if(user == null) throw new BadRequestException("Null user");
		
		log.info("Add address...");
		Address addr = addrRepo.save(bh.getAddress());
		
		if(addr == null) throw new BadRequestException("Null address");
		
		Housing house = this.mapHousing(bh);
		
		house.setAddress(addr);
		house.setUser(user);
		
		house = housingRepo.save(house);
		
		return house;
	}
	
	
	private Housing mapHousing(BrokenHousing bh) {
		Housing house = new Housing();
		
		house.setDescription(bh.getDescription());
		house.setPricePerMonth(bh.getPricePerMonth());
		
		return house;
	}
	
}
