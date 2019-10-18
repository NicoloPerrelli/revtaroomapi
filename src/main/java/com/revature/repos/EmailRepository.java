package com.revature.repos;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.revature.entities.EmailPackage;

@Repository
public class EmailRepository {
	
	private SessionFactory factory;

	public EmailRepository(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}
	
	public boolean sendEmail(EmailPackage email) {
		
		return true;
	}
}
