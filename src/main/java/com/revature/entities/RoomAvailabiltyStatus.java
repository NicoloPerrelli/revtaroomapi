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
@Table(name="ROOM_AVAILABILTY_STATUS")
@SequenceGenerator(name="role_pk_gen", sequenceName="status_seq", allocationSize=1)
public class RoomAvailabiltyStatus {

	@Id
	@Column(name="STATUS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="STATUS")
	private String status;
	
	
	
	public RoomAvailabiltyStatus() {
		super();
	}

	public RoomAvailabiltyStatus(int id) {
		this.id = id;
		
		switch(id) {
		case 1:
			status = "YES";
			break;
		case 2:
			status = "NO";
			break;
		default:
			status = "CONTACT OWNER";
		}
	}

	public RoomAvailabiltyStatus(String status) {
		this.status = status;
		
		switch(status.toUpperCase()) {
		case "YES":
			id = 1;
			break;
		case "NO":
			id = 2;
			break;
		default:
			id = 3;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RoomAvailabiltyStatus))
			return false;
		RoomAvailabiltyStatus other = (RoomAvailabiltyStatus) obj;
		return id == other.id && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "RoomAvailabiltyStatus [id=" + id + ", status=" + status + "]";
	}
	
	
}
