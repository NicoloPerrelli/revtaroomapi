package com.revature.revtaroom;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.entities.User;
import com.revature.entities.UserProfile;
import com.revature.services.ProfileService;
import com.revature.services.UserServices;
import com.revature.repos.UserRepository;

public class UserServiceTest {
	
	
	@InjectMocks
	UserServices userService;
	
	@Mock
	ProfileService pf;
	
	@Mock
	UserRepository repo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllUserTest_Success() {
		
		List<User> listOfUser = new ArrayList<User>();
		User user1 = new User("username", "password", "firstName", "lastName", "email");
		User user2 = new User("username1", "password1", "firstName1", "lastName1", "email1");
		User user3 = new User("username3", "password3", "firstName3", "lastName3", "email3");
		
		listOfUser.add(user1);
		listOfUser.add(user2);
		listOfUser.add(user3);
		
		when(repo.getAll()).thenReturn(listOfUser);
		
		List<User> list = userService.getAll();
		
		assertEquals(3, list.size());
		verify(repo, times(1)).getAll();
	}
	
	@Test
	public void getUserByIdTest_Success() {
		
		when(repo.getById(1)).thenReturn(new User(1, "username3", "password3", "firstName3", "lastName3", "email3"));
		
		User user = userService.getUserById(1);
		
		assertEquals(1, user.getId());
	}

	@Test
	public void createUserTest_Success() {
		
		UserProfile profile = new UserProfile();
		User user = new User(1,"username", "password", "firstName", "lastName", "email");
		user.setProfile(profile);
		profile.setUser(user);
		
		userService.register(user);
		
		verify(repo, times(1)).save(user);
	}
	

	@Test
	public void getEmailTest() {
		
		when(repo.getByEmail("email")).thenReturn(new User("email"));
		
		User user = userService.getByEmail("email");
		
		assertEquals("email", user.getEmail());
		
	}
	
	@Test
	public void updateUserTest() {
		
		User user = new User(1,"username", "password", "firstName", "lastName", "email");
		when(repo.update(user)).thenReturn(true);
		
		assertEquals(true, userService.updateUser(user));
		
	}
	
	@Test
	public void updateUserTest_Fail() {
		
		User user = new User(1,"username", "password", "firstName", "lastName", "email");
		when(repo.update(user)).thenReturn(false);
		
		assertEquals(false, userService.updateUser(user));
		
	}
	

   
}
