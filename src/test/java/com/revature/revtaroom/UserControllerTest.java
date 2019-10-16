//package com.revature.revtaroom;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.atLeastOnce;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.hamcrest.Matchers.*;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.controllers.AuthController;
//import com.revature.controllers.UserController;
//import com.revature.dtos.Credentials;
//import com.revature.entities.Role;
//import com.revature.entities.User;
//import com.revature.filters.AuthFilter;
//import com.revature.services.UserServices;
//
//public class UserControllerTest {
//
//	private MockMvc mockMvc;
//
//    @Mock
//    private UserServices userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Before
//    public void init(){
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(userController)
//                .addFilters(new AuthFilter())
//                .build();
//    }
//    
//    @Test
//    public void test_get_all_success() throws Exception {
//    	Role role = new Role("USER");
//        List<User> users = Arrays.asList(
//                new User(1,"dt@gmail.com", "Daenerys", "Targaryen", "dtargaryen", "p4ssw0rd!", role),
//                new User(2, "json@gmail.com", "John", "Snow", "jsnow", "p4ssw0rd!", role));
//        when(userService.getAll()).thenReturn(users);
//        mockMvc.perform(get("/users"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].email", is("dt@gmail.com")))
//                .andExpect(jsonPath("$[0].firstName", is("Daenerys")))
//                .andExpect(jsonPath("$[0].lastName", is("Targaryen")))
//                .andExpect(jsonPath("$[0].username", is("dtargaryen")))
//                .andExpect(jsonPath("$[0].password", is("p4ssword!")))
//                .andExpect(jsonPath("$[0].role", is(role)))
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[1].email", is("jsnow@gmail.com")))
//                .andExpect(jsonPath("$[1].firstName", is("John")))
//                .andExpect(jsonPath("$[1].lastName", is("Snow")))
//                .andExpect(jsonPath("$[1].username", is("jsnow")))
//                .andExpect(jsonPath("$[1].password", is("p4ssword!")))
//                .andExpect(jsonPath("$[1].role", is(role)));
//        verify(userService, atLeastOnce()).getAll();
//        verifyNoMoreInteractions(userService);
//    }
//    
//    @Test
//    public void test_create_user_success() throws Exception {
//    	Role role = new Role("USER");
//		User user = new User("username", "password", "firstName", "lastName", "email", role);
//		
//		when((userService).register(user)).thenReturn(user);
//		assertEquals(user, userService.register(user));
//
//        mockMvc.perform(
//                post("/users/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(user)))
//                .andExpect(status().isCreated());
//                
//        verify(userService, atLeastOnce()).register(user);
//        verifyNoMoreInteractions(userService);
//    }
//    
//    /*
//    @Test
//    public void test_get_by_id_success() throws Exception {
//    	Role role = new Role("USER");
//        User user =  new User(1,"dt@gmail.com", "Daenerys", "Targaryen", "dtargaryen", "p4ssw0rd!", role);
//
//        when(userService.findById(1)).thenReturn(user);
//
//        mockMvc.perform(get("/users/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.username", is("Daenerys Targaryen")));
//
//        verify(userService, times(1)).findById(1);
//        verifyNoMoreInteractions(userService);
//    }
//
//    @Test
//    public void test_get_by_id_fail_404_not_found() throws Exception {
//
//        when(userService.findById(1)).thenReturn(null);
//
//        mockMvc.perform(get("/users/{id}", 1))
//                .andExpect(status().isNotFound());
//
//        verify(userService, times(1)).findById(1);
//        verifyNoMoreInteractions(userService);
//    }
//*/
//    // =========================================== Create New User ========================================
//
//   
//    
//    
///*
//    @Test
//    public void test_create_user_fail_409_conflict() throws Exception {
//        User user = new User("username exists");
//
//        when(userService.exists(user)).thenReturn(true);
//
//        mockMvc.perform(
//                post("/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(user)))
//                .andExpect(status().isConflict());
//
//        verify(userService, times(1)).exists(user);
//        verifyNoMoreInteractions(userService);
//    }
//
//    // =========================================== Update Existing User ===================================
///*
//    @Test
//    public void test_update_user_success() throws Exception {
//        User user = new User(1, "Arya Stark");
//
//        when(userService.findById(user.getId())).thenReturn(user);
//        doNothing().when(userService).update(user);
//
//        mockMvc.perform(
//                put("/users/{id}", user.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(user)))
//                .andExpect(status().isOk());
//
//        verify(userService, times(1)).findById(user.getId());
//        verify(userService, times(1)).update(user);
//        verifyNoMoreInteractions(userService);
//    }
//
//    @Test
//    public void test_update_user_fail_404_not_found() throws Exception {
//        User user = new User(UNKNOWN_ID, "user not found");
//
//        when(userService.findById(user.getId())).thenReturn(null);
//
//        mockMvc.perform(
//                put("/users/{id}", user.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(user)))
//                .andExpect(status().isNotFound());
//
//        verify(userService, times(1)).findById(user.getId());
//        verifyNoMoreInteractions(userService);
//    }
//
//    // =========================================== Delete User ============================================
///*
//    @Test
//    public void test_delete_user_success() throws Exception {
//        User user = new User(1, "Arya Stark");
//
//        when(userService.findById(user.getId())).thenReturn(user);
//        doNothing().when(userService).delete(user.getId());
//
//        mockMvc.perform(
//                delete("/users/{id}", user.getId()))
//                .andExpect(status().isOk());
//
//        verify(userService, times(1)).findById(user.getId());
//        verify(userService, times(1)).delete(user.getId());
//        verifyNoMoreInteractions(userService);
//    }
//    */
///*
//    @Test
//    public void test_delete_user_fail_404_not_found() throws Exception {
//        User user = new User(UNKNOWN_ID, "user not found");
//
//        when(userService.findById(user.getId())).thenReturn(null);
//
//        mockMvc.perform(
//                delete("/users/{id}", user.getId()))
//                .andExpect(status().isNotFound());
//
//        verify(userService, times(1)).findById(user.getId());
//        verifyNoMoreInteractions(userService);
//    }
//
//    // =========================================== CORS Headers ===========================================
//
//    @Test
//    public void test_cors_headers() throws Exception {
//        mockMvc.perform(get("/users"))
//                .andExpect(header().string("Access-Control-Allow-Origin", "*"))
//                .andExpect(header().string("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE"))
//                .andExpect(header().string("Access-Control-Allow-Headers", "*"))
//                .andExpect(header().string("Access-Control-Max-Age", "3600"));
//    }
//*/
//    /*
//     * converts a Java object into JSON representation
//     */
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}