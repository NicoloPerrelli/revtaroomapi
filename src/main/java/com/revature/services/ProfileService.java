package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.entities.UserProfile;
import com.revature.repos.UserProfileRepository;

@Service
public class ProfileService {

	private UserProfileRepository profileRepo;

	@Autowired
	public ProfileService(UserProfileRepository repo) {
		this.profileRepo = repo;
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
	
	public UserProfile newProfile(UserProfile newProfile) {
		System.out.println("ProfileService.save Invoked!");
		
		profileRepo.save(newProfile);
	
		return newProfile;
	}
	
	
}
