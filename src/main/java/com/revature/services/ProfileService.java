package com.revature.services;

import com.revature.entities.UserProfile;
import com.revature.repos.UserProfileRepository;
import com.revature.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateProfile(int id, UserProfile upadatedProfile, int type) {
		System.out.println("ProfileService.updateProfile Invoked!");
		return profileRepo.updateWithId(id, upadatedProfile, type);
	}
	
	@Transactional
	public UserProfile newProfile(UserProfile newProfile) {
		System.out.println("ProfileService.save Invoked!");
		profileRepo.save(newProfile);
		return newProfile;
	}

	
}
