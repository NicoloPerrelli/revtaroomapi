package com.revature.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER_PROFILE")
@SequenceGenerator(name="id_pk", sequenceName="user_profile_seq", allocationSize = 1)
public class UserProfile {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_pk")
	private int id;
	
	
	@Column(name="DESCRIPTION", length = 400)
	private String description;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="TRAINING_TYPE_FK")
	private TrainingType trainingType;
	
	public UserProfile() {
		super();
	}

	public UserProfile(int id) {
		super();
		this.id = id;
	}
	
	public UserProfile(String description) {
		super();
		this.description = description;
	}
	
	public UserProfile(String description, TrainingType trainingType) {
		super();
		this.description = description;
		this.trainingType = trainingType;
	}

	public UserProfile(int id, String description, TrainingType trainingType) {
		super();
		this.id = id;
		this.description = description;
		this.trainingType = trainingType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TrainingType getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(description, id, trainingType);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof UserProfile))
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(trainingType, other.trainingType);
	}
	
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", description=" + description + ", trainingType=" + trainingType + "]";
	}
}
