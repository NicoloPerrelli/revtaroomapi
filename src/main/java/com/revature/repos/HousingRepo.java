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
		return (Housing) factory.getCurrentSession()
				.createQuery("from Housing H where H.id = :idd", Housing.class)
				.setParameter("idd",id).getSingleResult();
	}
	
	public Housing getByUserId(int id) {
		// TODO
		return null;
	}

	@Override
	public Housing save(Housing newObj) {
		// TODO Auto-generated method stub
		return null;
	}

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
