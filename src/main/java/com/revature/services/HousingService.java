package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Housing;
import com.revature.repos.HousingRepo;

@Service
public class HousingService {
	
	private HousingRepo housingRepo;
	
	@Autowired
	public HousingService(HousingRepo repo) {
		this.housingRepo = repo;
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
	public Housing addHousing(Housing house) {
		System.out.println("In service addHousing...");
		house = housingRepo.save(house);
		return house;
	}
}
