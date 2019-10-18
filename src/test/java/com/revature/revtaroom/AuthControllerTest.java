/*
package com.revature.revtaroom;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.AuthController;
import com.revature.dtos.Credentials;
import com.revature.entities.User;
import com.revature.filters.AuthFilter;
import com.revature.services.UserServices;

public class AuthControllerTest {
	
	private MockMvc mockMvc;

    @Mock
    private UserServices userService;

    @InjectMocks
    private AuthController authController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(authController)
                .addFilters(new AuthFilter())
                .build();
    }
    
    @Test
    public void test_login_user() throws Exception {
    	Credentials creds = new Credentials("email@test.com", "password");
    	User user = new User("email@test.com", "password");
    	when(userService.login(creds)).thenReturn(user);
		assertEquals(user, userService.login(creds));

        mockMvc.perform(
                post("/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(creds)))
                        .andExpect(status().isUnauthorized());
                
        verify(userService, atLeastOnce()).login(creds);
        verifyNoMoreInteractions(userService);
    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
*/
