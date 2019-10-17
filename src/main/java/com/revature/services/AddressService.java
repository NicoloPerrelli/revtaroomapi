package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Address;
import com.revature.repos.AddressRepository;


@Service
public class AddressService {
	
	private AddressRepository addressRepo;
	
	@Autowired
	public AddressService(AddressRepository ar) {
		this.addressRepo = ar;
	}
	
	@Transactional()
	public List<Address> getAllAdresses() {
		return addressRepo.getAll();
	}
	
}
