/*
package com.revature.revtaroom;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.AuthController;
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
    public void test_cors_headers() throws Exception {
        mockMvc.perform(post("/auth"))
                .andExpect(header().string("Access-Control-Allow-Origin", "*"))
                .andExpect(header().string("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE"))
                .andExpect(header().string("Access-Control-Allow-Headers", "Content-type, Authorization"))
                .andExpect(header().string("Access-Control-Expose-Headers", "Authorization"));
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
