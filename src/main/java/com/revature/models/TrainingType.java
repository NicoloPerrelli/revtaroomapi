package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TRAINING_TYPE")
@SequenceGenerator(name="training_type_pk_gen", sequenceName="training_type_seq", allocationSize=1)
public class TrainingType {
	
	@Id
	@Column(name="TRAINING_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="TRAINING_TYPE")
	private String name;
	
	
	public TrainingType() {
		super();
	}
	
	public TrainingType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
