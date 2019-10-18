package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.revature.entities.TrainingType;
import com.revature.entities.UserProfile;

@Repository
public class UserProfileRepository implements CrudRepository<UserProfile> {

	private SessionFactory factory;

	public UserProfileRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}

	@Override
	public List<UserProfile> getAll() {

		return factory.getCurrentSession().createQuery("from UserProfile", UserProfile.class).getResultList();
	}

	@Override
	public UserProfile getById(int id) {

		return factory.getCurrentSession().get(UserProfile.class, id);
	}

	@Override
	public UserProfile save(UserProfile newObj) {

		factory.getCurrentSession().save(newObj);
		return newObj;
	}

	@Override
	public boolean update(UserProfile updatedObj) {

		Session session = factory.getCurrentSession();
		UserProfile userProfileInDb = session.get(UserProfile.class, updatedObj.getId());

		if (userProfileInDb == null)
			return false;

		userProfileInDb.setDescription(updatedObj.getDescription());
		userProfileInDb.setTrainingType(updatedObj.getTrainingType());

		return true;
	}

	@Override
	public boolean deleteById(int id) {
		return false;
	}

	public boolean updateWithId(int id, UserProfile upadatedProfile, int type) {
		upadatedProfile.setId(id);
		Session session = factory.getCurrentSession();
		UserProfile userProfileInDb = session.get(UserProfile.class, upadatedProfile.getId());
		
		System.out.println("before the change --- "+userProfileInDb);
		if(userProfileInDb == null)return false;
		System.out.println(userProfileInDb.getTrainingType().getId());
		System.out.println(userProfileInDb.getTrainingType().getName());
		
		userProfileInDb.setDescription(upadatedProfile.getDescription());
		TrainingType typeObj = new TrainingType(type);
		if(typeObj.getId() != (userProfileInDb.getTrainingType().getId())) {
			System.out.println("type was different!");
			userProfileInDb.setTrainingType(typeObj);
		}
		
		System.out.println("after the change --- "+userProfileInDb);
		session.saveOrUpdate(userProfileInDb);
		
		System.out.println(userProfileInDb.getTrainingType().getId());
		System.out.println(userProfileInDb.getTrainingType().getName());
		
		return true;
	}

}
