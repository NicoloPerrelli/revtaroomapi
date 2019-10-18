package com.revature.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.revature.entities.UserProfile;
import com.revature.repos.UserProfileRepository;
import com.revature.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;





@Service
public class ProfileService {

	private static Logger log = LogManager.getLogger(ProfileService.class);
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
	public boolean updateProfile(int id, UserProfile upadatedProfile) {
		System.out.println("ProfileService.updateProfile Invoked!");
		return profileRepo.updateWithId(id, upadatedProfile);
	}
	
	@Transactional
	public UserProfile newProfile(UserProfile newProfile) {
		log.info("ProfileService.save Invoked!");
		profileRepo.save(newProfile);
		return newProfile;
	}

	
}
