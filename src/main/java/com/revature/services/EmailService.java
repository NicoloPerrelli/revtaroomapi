package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.EmailPackage;
import com.revature.repos.EmailRepository;

@Service
public class EmailService {

	private EmailRepository emailRepo;

	@Autowired
	public EmailService(EmailRepository repo) {
		this.emailRepo = repo;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public boolean sendEmail(EmailPackage email) {
		return emailRepo.sendEmail(email);
	}
	

	
}
