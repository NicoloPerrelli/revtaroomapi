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
	private int trainingId;
	
	@Column(name="TRAINING_TYPE")
	private String trainingType;
	
	
	public TrainingType() {
		super();
	}
	

	public TrainingType(int id) {
		this.trainingId = id;
		
		switch(id) {
		case 1:
			this.trainingType = "JAVA";
			break;
		case 2:
			this.trainingType = "DEVOPS";
			break;
		case 3:
			this.trainingType = "C#";
			break;
		default:
			this.trainingType = "ANGULAR";
		}
	}

	public TrainingType(String name) {
		this.trainingType = name;
		
		switch(name.toUpperCase()) {
		case "JAVA":
			this.trainingId = 1;
			break;
		case "DEVOPS":
			this.trainingId = 2;
			break;
		case "C#":
			this.trainingId = 3;
			break;
		case "ANGULAR":
			this.trainingId = 4;
			break;
		case "1":
			this.trainingType="JAVA";
			this.trainingId = 1;
			break;
		case "2":
			this.trainingType="DEVOPS";
			this.trainingId = 2;
			break;
		case "3":
			this.trainingType="C#";
			this.trainingId = 3;
			break;
		case "4":
			this.trainingType="ANGULAR";
			this.trainingId = 4;
			break;
		default:
			this.trainingType="ANGULAR";
			this.trainingId = 4;
		}
	}
	

	public int getId() {
		return trainingId;
	}

	public void setId(int id) {
		this.trainingId = id;
	}

	public String getName() {
		return trainingType;
	}

	public void setName(String name) {
		this.trainingType = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + trainingId;
		result = prime * result + ((trainingType == null) ? 0 : trainingType.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingType other = (TrainingType) obj;
		if (trainingId != other.trainingId)
			return false;
		if (trainingType == null) {
			if (other.trainingType != null)
				return false;
		} else if (!trainingType.equals(other.trainingType))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TrainingType [trainingId=" + trainingId + ", trainingType=" + trainingType + "]";
	}
	
	
	
}
