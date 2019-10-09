package com.revature;

import org.hibernate.Session;

import com.revature.models.Role;
import com.revature.util.HibernateUtil;

public class HelloLombok {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		Role rl = new Role(1,"USER");
		session.save(rl);
		
		System.out.println(rl);
		
	}

}
