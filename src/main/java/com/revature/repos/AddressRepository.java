package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.Address;


@Repository
public class AddressRepository implements CrudRepository<Address> {
	
	private SessionFactory factory;
	
	@Autowired
	public AddressRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}

	@Override
	public List<Address> getAll() {
		return factory.getCurrentSession().createQuery("from Address", Address.class).getResultList();
	}

	@Override
	public Address getById(int id) {
		return factory.getCurrentSession().get(Address.class, id);
	}

	@Override
	public Address save(Address newObj) {
		factory.getCurrentSession().save(newObj);
	
		return newObj;
	}
	
	@Override
	public boolean update(Address updatedObj) {
		
		Session session = factory.getCurrentSession();
		Address addressInDb = session.get(Address.class, updatedObj.getId());
		
		if(addressInDb == null) return false;
		
		addressInDb.setStreetAddress(updatedObj.getStreetAddress());
		addressInDb.setCity(updatedObj.getCity());
		addressInDb.setState(updatedObj.getState());
		addressInDb.setZipCode(updatedObj.getZipCode());
		addressInDb.setLatitude(updatedObj.getLatitude());
		addressInDb.setLongitude(updatedObj.getLongitude());
		
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		
		return false;
	}

}
