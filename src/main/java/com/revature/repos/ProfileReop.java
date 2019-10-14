package com.revature.repos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.UserProfile;

@Repository
public class ProfileReop {

	private SessionFactory factory;
	
	@Autowired
	public ProfileReop(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}

	public UserProfile getProfileById(int id) {
		return factory.getCurrentSession().get(UserProfile.class, id);
	}
	
	public boolean update(UserProfile updatedProfile) {
		Session session = factory.getCurrentSession();
		UserProfile profileInDb = session.get(UserProfile.class, updatedProfile.getId());
		
		if(profileInDb == null) return false;
		
		profileInDb.setDescription(updatedProfile.getDescription());
		profileInDb.setTrainingType(updatedProfile.getTrainingType());
		return true;
	}
}
