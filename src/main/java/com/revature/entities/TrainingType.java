package com.revature.entities;

import java.util.Objects;

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
	

	public TrainingType(int id) {
		this.id = id;
		
		switch(id) {
		case 1:
			name = "JAVA";
			break;
		case 2:
			name = "ANGULAR";
			break;
		case 3:
			name = "C#";
			break;
		default:
			name = "OTHER";
		}
	}

	public TrainingType(String name) {
		this.name = name;
		
		switch(name.toUpperCase()) {
		case "JAVA":
			id = 1;
			break;
		case "ANGULAR":
			id = 2;
			break;
		case "C#":
			id = 3;
			break;
		default:
			id = 4;
		}
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


	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TrainingType))
			return false;
		TrainingType other = (TrainingType) obj;
		return id == other.id && Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "TrainingType [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
