package com.revature.repos;

import java.util.List;

public interface CrudRepository<T> {

	List<T> getAll();
	T getById(int id);
	T save(T newObj);
	boolean update(T updatedObj);
	boolean deleteById(int id);
	
}
