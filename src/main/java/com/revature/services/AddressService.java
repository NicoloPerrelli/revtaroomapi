package com.revature.services;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Address;
import com.revature.filters.AuthFilter;
import com.revature.repos.AddressRepository;


@Service
public class AddressService {
	
	private static Logger log = LogManager.getLogger(AddressService.class);
	private AddressRepository addressRepo;
	
	@Autowired
	public AddressService(AddressRepository ar) {
		this.addressRepo = ar;
	}
	
	@Transactional()
	public List<Address> getAllAdresses() {
		log.info("inside addressRepo.getAllAddresses invocked!");
		return addressRepo.getAll();
	}
	
}
