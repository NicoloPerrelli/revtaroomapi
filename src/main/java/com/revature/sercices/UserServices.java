package com.revature.sercices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Role;
import com.revature.entities.User;
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
	public User login(String username, String password) {
		System.out.println("UserService.login Invoked!");

		if (username == null || username.equals("") || password == null || password.equals("")) {
			System.out.println("non-value provided for username/password!");
			return null;
		}

		return (User) userRepo.getUserByCredentials(username, password);
	}

	@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
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
		
		if(!usernameAvailable || !emailAvailable) {
			System.out.println("Provided username/email is already taken - user not created");
			return null;
		}
		
		System.out.println("Setting role of new users to \"USER\"");
		newUser.setRole(new Role("USER"));
		
		return userRepo.add(newUser);
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
