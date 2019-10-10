package com.revature.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_PROFILE")
@SequenceGenerator(name="id_pk", sequenceName="user_profile_seq", allocationSize = 1)
public class UserProfile {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="TRAINING_TYPE_FK")
	private TrainingType trainingType;

	public UserProfile(int id, String description, TrainingType trainingType) {
		super();
		this.id = id;
		this.description = description;
		this.trainingType = trainingType;
	}
	
	
	 
	
}
