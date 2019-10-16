package com.revature.services;

import com.revature.entities.UserProfile;
import com.revature.repos.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.entities.UserProfile;
import com.revature.repos.UserProfileRepository;
import com.revature.repos.UserRepository;

@Service
public class ProfileService {
	
	private UserProfileRepository profileRepo;
	private UserRepository userRepo;

	@Autowired
	public ProfileService(UserProfileRepository repo, UserRepository userRepo) {
		this.profileRepo = repo;
		this.userRepo = userRepo;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public UserProfile getById(int id) {
		return profileRepo.getById(id);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public boolean updateProfile(UserProfile upadatedProfile) {
		System.out.println("ProfileService.updateProfile Invoked!");
		return profileRepo.update(upadatedProfile);
	}
	
	@Transactional
	public UserProfile newProfile(UserProfile newProfile) {
		System.out.println("ProfileService.save Invoked!");
		profileRepo.save(newProfile);
		return newProfile;
	}
	
}
