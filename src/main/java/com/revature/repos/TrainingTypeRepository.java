package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.TrainingType;

@Repository
public class TrainingTypeRepository implements CrudRepository<TrainingType> {

	private SessionFactory factory;
	
	@Autowired
    public TrainingTypeRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	@Override
	public List<TrainingType> getAll() {
		
		return factory.getCurrentSession().createQuery("from TraingType", TrainingType.class).getResultList();
	}

	@Override
	public TrainingType getById(int id) {
		
		return factory.getCurrentSession().get(TrainingType.class, id);
	}

	@Override
	public TrainingType save(TrainingType newObj) {
		
		factory.getCurrentSession().save(newObj);
		return newObj;
	}

	@Override
	public boolean update(TrainingType updatedObj) {
		
		Session session = factory.getCurrentSession();
		TrainingType trainingTypeInDb = session.get(TrainingType.class, updatedObj.getId());
		
		if(trainingTypeInDb == null) return false;
		
		trainingTypeInDb.setName(updatedObj.getName());
		
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
