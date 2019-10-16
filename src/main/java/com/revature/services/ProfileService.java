package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.UserProfile;
import com.revature.repos.ProfileReop;

@Service
public class ProfileService {

	private ProfileReop profileReop;

	@Autowired
	public ProfileService(ProfileReop repo) {
		this.profileReop = repo;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public UserProfile getById(int id) {
		return profileReop.getProfileById(id);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public boolean updateProfile(UserProfile upadatedProfile) {
		System.out.println("ProfileService.updateProfile Invoked!");
		return profileReop.update(upadatedProfile);
	}
}
