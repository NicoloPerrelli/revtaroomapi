package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.RoomForRent;

@Repository
public class RoomForRentRepository implements CrudRepository<RoomForRent>{

	private SessionFactory factory;
	
	@Autowired
	public RoomForRentRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	
	@Override
	public List<RoomForRent> getAll() {
		
		return factory.getCurrentSession()
				.createNamedQuery("getAllAviableRooms", RoomForRent.class)
				.getResultList();
	}
	
	public List<RoomForRent> getRoomByUserId(int userId) {
		
		return factory.getCurrentSession()
				.createNamedQuery("getByUserId", RoomForRent.class)
				.setParameter("id", userId)
				.getResultList();
	}

	@Override
	public RoomForRent getById(int id) {
		
		return factory.getCurrentSession().get(RoomForRent.class, id);
	}

	@Override
	public RoomForRent save(RoomForRent newObj) {
		
		factory.getCurrentSession().save(newObj);
		return newObj;
	}

	@Override
	public boolean update(RoomForRent updatedObj) {
		
		Session session = factory.getCurrentSession();
		RoomForRent roomInDb = session.get(RoomForRent.class, updatedObj.getId());
		
		if(roomInDb == null) return false;
		
		roomInDb.setHouse(updatedObj.getHouse());
		roomInDb.setPricePerMonth(updatedObj.getPricePerMonth());
		
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
