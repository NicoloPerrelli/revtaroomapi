package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dtos.Credentials;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.BadRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.repos.UserRepository;

@Service
public class UserServices {

	private UserRepository userRepo;

	@Autowired
	public UserServices(UserRepository repo) {
		this.userRepo = repo;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public User getByUsername(String username) {
		System.out.println("UserService.getByUsername Invoked!");

		if (username == null || username.equals("")) {
			System.out.println("non-value provided for username!");
			return null;
		}

		return userRepo.getByUsername(username);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public User getByEmail(String email) {
		System.out.println("UserService.getByUsername Invoked!");

		if (email == null || email.equals("")) {
			System.out.println("non-value provided for username!");
			return null;
		}

		return userRepo.getByEmail(email);
	}
	
	@Transactional(readOnly=true)
	public User getUserById(int id) {
		
		if(id <= 0) {
			throw new BadRequestException("Invalid id provided");
		} 
		User tempId = userRepo.getById(id);
		if(id != tempId.getId()) {
			throw new ResourceNotFoundException("No card found with provided id");
		}
		return tempId;
	}
	

	@Transactional(readOnly = true)
	public User login(Credentials creds) {
		System.out.println("UserService.login Invoked!");

		if(creds == null || creds.getEmail() == null || creds.getPassword() == null
				|| creds.getEmail().equals("") || creds.getPassword().equals(""))
		{
			throw new BadRequestException("Invalid credentials object provided");
		}
		
		User retrievedUser = userRepo.getUserByCredentials(creds.getEmail(), creds.getPassword());
		
		if(retrievedUser == null) {
			throw new SecurityException("No user found with provided credentials");
		}
		
		return retrievedUser;
	}
	

	@Transactional
	public User register(User newUser) {
		System.out.println("UserService.register Invoked!");
		
		String username = newUser.getUsername();
		String email = newUser.getEmail();
		
		if (!validateUserFields(newUser)) {
			System.out.println("Invalid fields found on user object");
			return null;
		}
		
		boolean usernameAvailable = userRepo.getByUsername(username) == null;
		boolean emailAvailable = userRepo.getByEmail(email) == null;
		
		if(!usernameAvailable && !emailAvailable ) {
			System.out.println("Provided username/email is already taken - user not created");
			return null;
		}
		
		System.out.println("Setting role of new users to \"USER\"");
		newUser.setRole(new Role("USER"));
		
		return userRepo.save(newUser);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public boolean updateUser(User updatedUser) {
		System.out.println("UserService.updateUser Invoked!");
		
		if(!validateUserFields(updatedUser)) {
			System.out.println("Invalid fields found on object!");
			return false;
		}
		
		return userRepo.update(updatedUser);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<User> getAll() {
		return userRepo.getAll();
	}
	
	private boolean validateUserFields(User user) {
		System.out.println("Validating User fields...");
		
		if(user.getUsername().trim().equals("") || user.getUsername() == null) return false;
		if(user.getPassword().trim().equals("") || user.getPassword() == null) return false;
		if(user.getFirstName().trim().equals("") || user.getFirstName() == null) return false;
		if(user.getLastName().trim().equals("") || user.getLastName() == null) return false;
		if(user.getEmail().trim().equals("") || user.getEmail() == null) return false;
		
		return true;
	}

}
