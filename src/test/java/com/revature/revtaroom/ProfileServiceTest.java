package com.revature.revtaroom;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.entities.TrainingType;
import com.revature.entities.UserProfile;
import com.revature.repos.UserProfileRepository;
import com.revature.services.ProfileService;

@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest {
	
	@InjectMocks
	ProfileService profileService;
	
	@Mock
	UserProfileRepository profileRepo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getByIdTest1() {
		UserProfile profileOne = new UserProfile(1, "this is my bio", new TrainingType(1));
		UserProfile profileTwo = new UserProfile(2, "this is my bio too", new TrainingType(2));
		UserProfile profileThree = new UserProfile(3, "this is not my bio", new TrainingType(3));
		
		when(profileRepo.getById(1)).thenReturn(profileOne);
		
		UserProfile profList = profileService.getById(1);
		
		assertEquals(profileOne, profList);
	}
	
	@Test
	public void getByIdTest2() {
		UserProfile profileOne = new UserProfile(1, "this is my bio", new TrainingType(1));
		UserProfile profileTwo = new UserProfile(2, "this is my bio too", new TrainingType(2));
		UserProfile profileThree = new UserProfile(3, "this is not my bio", new TrainingType(3));
		
		when(profileRepo.getById(2)).thenReturn(profileTwo);
		
		UserProfile profList = profileService.getById(2);
		
		assertEquals(profileTwo, profList);
	}
	
	@Test
	public void updateProfileTest1() {
		UserProfile beforeUp = new UserProfile(2, "this is my bio too", new TrainingType(2));
		Boolean afterUp = true;
		
		when(profileRepo.updateWithId(2, (beforeUp), 3)).thenReturn(afterUp);
		
		boolean expectedUp = profileService.updateProfile(2, beforeUp, 3);
		
		assertEquals(afterUp, expectedUp);
	}
	

//	@Test
//	public void newProfileTest1() {
//		UserProfile profileOne = new UserProfile(1, "", new TrainingType(1));
//		UserProfile profileTwo = new UserProfile(1, "", new TrainingType(1));
//		
//		when(profileRepo.save(profileOne));
//		
//		UserProfile profList = profileService.newProfile(profileOne);
//		
//		assertEquals(profileTwo, profList);
//	}
	
	
}
