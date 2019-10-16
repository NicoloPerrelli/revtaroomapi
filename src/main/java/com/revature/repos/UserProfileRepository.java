package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateWithId(int id, UserProfile upadatedProfile) {
		System.out.println("WE ARE UPDATING WITH THESE - "+id+" / "+upadatedProfile);
		Session session = factory.getCurrentSession();
		UserProfile userProfileInDb = session.get(UserProfile.class, upadatedProfile.getId());

		if (userProfileInDb == null)
			return false;

		userProfileInDb.setDescription(upadatedProfile.getDescription());
		userProfileInDb.setTrainingType(upadatedProfile.getTrainingType());

		return true;
	}

}
