package com.revature.services;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dtos.Credentials;
import com.revature.entities.Role;
import com.revature.entities.TrainingType;
import com.revature.entities.User;
import com.revature.entities.UserProfile;
import com.revature.exceptions.BadRequestException;
import com.revature.exceptions.ResourceCreationException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.exceptions.SecurityExceptions;
import com.revature.repos.UserRepository;

@Service
public class UserServices {

	private static Logger log = LogManager.getLogger(UserServices.class);
	
	private UserRepository userRepo;
	private ProfileService profileService;
	

	@Autowired
	public UserServices(UserRepository repo, ProfileService profs) {
		this.userRepo = repo;
		this.profileService = profs;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public User getByUsername(String username) {
		log.info("UserService.getByUsername Invoked!");

		if (username == null || username.equals("")) {
			log.info("non-value provided for username!");
			return null;
		}

		return userRepo.getByUsername(username);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public User getByEmail(String email) {
		log.info("UserService.getByEmail Invoked!");

		if (email == null || email.equals("")) {
			log.info("non-value provided for username!");
			
			return null;
		}

		return userRepo.getByEmail(email);
	}
	
	@Transactional(readOnly=true)
	public User getUserById(int id) {
		log.info("UserService.getByIdInvoked!");
		
		if(id <= 0) {
			throw new BadRequestException("Invalid id provided");
		} 
		User tempId = userRepo.getById(id);
		if(id != tempId.getId()) {
			throw new ResourceNotFoundException("No user found with provided id");
		}
		return tempId;
	}
	

	@Transactional(readOnly = true)
	public User login(Credentials creds) {
		log.info("UserService.login Invoked!");

		if(creds == null || creds.getEmail() == null || creds.getPassword() == null
				|| creds.getEmail().equals("") || creds.getPassword().equals(""))
		{
			throw new BadRequestException("Invalid credentials object provided");
		}
		
		User retrievedUser = userRepo.getUserByCredentials(creds.getEmail(), creds.getPassword());
		
		if(retrievedUser == null) {
			throw new SecurityExceptions("No user found with provided credentials");
		}
		
		return retrievedUser;
	}
	

	@Transactional
	public User register(User newUser) {
		log.info("UserService.register Invoked!");
		
		String username = newUser.getUsername();
		String email = newUser.getEmail();
		
		if (!validateUserFields(newUser)) {
			log.info("Invalid fields found on user object");
			return null;
		}
		
		boolean usernameAvailable = userRepo.getByUsername(username) == null;
		boolean emailAvailable = userRepo.getByEmail(email) == null;
		
		if(!usernameAvailable && !emailAvailable ) {
			log.info("Provided username/email is already taken - user not created");
			throw new ResourceCreationException("Provided username/email is already taken - user not created");
			
		}
		
		log.info("Setting role of new users to \"USER\"");
		newUser.setRole(new Role("USER"));
		
		System.out.println(newUser);
		
		UserProfile profile = new UserProfile();
		
		log.info("set parent and child reference");
		newUser.setProfile(profile);
		
		log.info("Setting default description to new profile");
		profile.setDescription("Welcome to Revtaroom");
		
		log.info("Setting default training type to new profile");
		profile.setTrainingType(new TrainingType("OTHER"));
		profile.setUser(newUser);
	
		profileService.newProfile(profile);
	    userRepo.save(newUser);
		
		return newUser;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public boolean updateUser(User updatedUser) {
		log.info("UserService.updateUser Invoked!");
		
		if(!validateUserFields(updatedUser)) {
			log.info("Invalid fields found on object!");
			return false;
		}
		
		return userRepo.update(updatedUser);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<User> getAll() {
		log.info("UserService.getAll Invoked!");
		return userRepo.getAll();
	}
	
	private boolean validateUserFields(User user) {
		log.info("Validating User fields...");
		
		if(user.getUsername().trim().equals("") || user.getUsername() == null) return false;
		if(user.getPassword().trim().equals("") || user.getPassword() == null) return false;
		if(user.getFirstName().trim().equals("") || user.getFirstName() == null) return false;
		if(user.getLastName().trim().equals("") || user.getLastName() == null) return false;
		if(user.getEmail().trim().equals("") || user.getEmail() == null) return false;
		
		return true;
	}

}
