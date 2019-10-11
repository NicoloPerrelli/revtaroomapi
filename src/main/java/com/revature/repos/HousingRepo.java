package com.revature.repos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.Housing;

@Repository
public class HousingRepo implements CrudRepository<Housing>{
	
	private SessionFactory factory;
	
	@Autowired
	public HousingRepo(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Override
	public List<Housing> getAll() {
		return factory.getCurrentSession().createQuery("from Housing", Housing.class).getResultList();
	}

	@Override
	public Housing getById(int id) {
		//TODO
		return null;
	}
	
	/**
	 * Get all the Housing objects related to that userId.
	 * If no housing is found, return null
	 * 
	 * @param userId
	 * @return
	 */
	public List<Housing> getByUserId(int userId) {
		// TODO
		return null;
	}
	
	
	/**
	 * First, insert the address of this housingObj in the database
	 * and get the id back. Then, insert this Housing object with
	 * the correct ADDRESS_ID to the database and return
	 * the object with the HOUSING_ID it has in the database.
	 * @param housingObj
	 * @return housingObj
	 */
	@Override
	public Housing save(Housing housingObj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Update the object that has the same id this one has
	 * in the database.
	 * 
	 * @param housingObj
	 * @return boolean
	 */
	@Override
	public boolean update(Housing updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
