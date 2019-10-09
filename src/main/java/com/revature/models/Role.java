package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
@SequenceGenerator(name="role_pk_gen", sequenceName="role_seq", allocationSize=1)
public class Role {
	
	@Id
	@Column(name="USER_ROLE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="USER_ROLE_NAME")
	private String name;
	
	public Role() {
		super();
	}

	public Role(int id, String name) {
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
