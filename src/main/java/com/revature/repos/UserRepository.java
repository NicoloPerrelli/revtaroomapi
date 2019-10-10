package com.revature.repos;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.User;

@Repository
public class UserRepository {
	
	private SessionFactory factory;
	
	@Autowired
	public UserRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	public User getByUsername(String username) {
		return factory.getCurrentSession().get(User.class, username);
		
	}
	
	public User getByEmail(String email) {
		return factory.getCurrentSession().get(User.class, email);
		
	}
	
	public User getUserByCredentials(String username, String password) {
		return factory.getCurrentSession()
				.createQuery("getUserByCredentials", User.class)
				.setParameter("un", username)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	public List<User> getAll(){
		return factory.getCurrentSession().createQuery("from User", User.class).getResultList();
	}
	
	public User getById(int id) {
		return factory.getCurrentSession().get(User.class, id);
	}

	public User add(User newUser) {
		factory.getCurrentSession().save(newUser);
		return newUser;
	}
	
	public boolean update(User updatedUser) {
		Session session = factory.getCurrentSession();
		User userInDb = session.get(User.class, updatedUser.getId());
		
		if(userInDb == null) return false;
		
		userInDb.setFirstName(updatedUser.getFirstName());
		userInDb.setLastName(updatedUser.getLastName());
		userInDb.setUsername(updatedUser.getUsername());
		userInDb.setPassword(updatedUser.getPassword());
		userInDb.setEmail(updatedUser.getEmail());
		
		return true;
		
	}
}
