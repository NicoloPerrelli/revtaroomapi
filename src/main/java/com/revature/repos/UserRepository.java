package com.revature.repos;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.User;

@Repository
public class UserRepository implements CrudRepository<User> {
	
	private SessionFactory factory;
	
	@Autowired
	public UserRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	public User getByUsername(String username) {
		return factory.getCurrentSession()
				.createNamedQuery("getByUsername", User.class)
				.setParameter("un", username)
				.getSingleResult();
		
	}
	
	public User getByEmail(String email) {
		return factory.getCurrentSession()
				.createNamedQuery("getByEmail", User.class)
				.setParameter("email", email)
				.getSingleResult();
		
	}
	
	public User getUserByCredentials(String email, String password) {
		return factory.getCurrentSession()
				.createNamedQuery("getUserByCredentials", User.class)
				.setParameter("un", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	@Override
	public List<User> getAll(){
		return factory.getCurrentSession().createQuery("from User", User.class).getResultList();
	}
	
	@Override
	public User getById(int id) {
		return factory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User save(User newUser) {
		factory.getCurrentSession().save(newUser);
		return newUser;
	}
	
	@Override
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

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
