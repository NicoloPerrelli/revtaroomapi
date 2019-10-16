package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Housing;
import com.revature.entities.User;
import com.revature.exceptions.BadRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.repos.HousingRepo;

@Service
public class HousingService {
	
	private HousingRepo housingRepo;
	
	@Autowired
	public HousingService(HousingRepo repo) {
		this.housingRepo = repo;
	}
	
	@Transactional
	public List<Housing> getAllHousing() {
		return housingRepo.getAll();
	}
	
	@Transactional
	public List<Housing> getHousingById(int id) {
		List<Housing> list = new ArrayList<>();
		System.out.println("Id:" + id);
		Housing housing = housingRepo.getById(id);
		if(housing != null) list.add(housing);
		return list;
	}
	
	@Transactional
	public List<Housing> postNotification(int userId) {
		
		if(userId <= 0) {
			throw new BadRequestException("Invalid id provided");
		} 
		
		List<Housing> tempId = housingRepo.getByUserId(userId);
		if(tempId.isEmpty()) {
			throw new ResourceNotFoundException("No Housing info found with provided id");
		}
		return tempId;
	}
	
}
