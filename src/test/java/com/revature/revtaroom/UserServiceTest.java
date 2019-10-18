package com.revature.revtaroom;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.UserController;
import com.revature.dtos.Credentials;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.filters.AuthFilter;
import com.revature.services.UserServices;


public class UserServiceTest {
	
	private MockMvc mockMvc;

    @InjectMocks
    private UserServices userService;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userService)
                .build();
    }
	
	
	@After
	public void reset() {
		userService.userDao = null;
	}
	
	@Test
	public void RegisterTest() {
		
		Role role = new Role("USER");
		User user = new User("username", "password", "firstName", "lastName", "email", role);
		user.setId(0);
		when(userService.userDao.add(user)).thenReturn(new User("username", "password", "firstName", "lastName", "email", role));
		when(userService.login("username", "password")).thenReturn(user);
		assertEquals(user, userService.register(user));
		
		
	}
	
	@Test
	public void loginTest() {
		
		when(userService.userDao.getUserByCredentials("username", "password")).thenReturn(null);
		assertEquals(null, userService.login("username", "password"));
		
	}
	
	
	@Test
	public void getAllUserTest() {
		
		
		when(userService.userDao.getAll()).thenReturn(null);
		assertEquals(null, userService.getAllUsers());
		
	}
	
	@Test
	public void getByUsernameTest() {
		
		User user = new User("username");
		when(userService.userDao.getUserByUsername("username")).thenReturn(user);
		assertEquals(user, userService.getUserByUsername("username"));
	}
	
	@Test
	public void updateUserTest() {
		
		Role role = new Role("USER");
		User user = new User(1,"username", "password", "firstName", "lastName", "email",role);
		when(userService.userDao.update(user)).thenReturn(user);
		assertEquals(user, userService.updateUser(user));
		
	}
	

   
}
