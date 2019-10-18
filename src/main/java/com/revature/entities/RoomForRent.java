package com.revature.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="getAllAviableRooms", query="from RoomForRent r where r.status = 1"),
	@NamedQuery(name="getByUserId", query="from Housing h, RoomForRent r where h.user = :id and h.id = r.house")
})

@Entity
@Table(name="ROOM_FOR_RENT")
@SequenceGenerator(name="id_pk", sequenceName="room_seq", allocationSize = 1)
public class RoomForRent {
	
	@Id
	@Column(name="ROOM_FOR_RENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_pk")
	private int id;
	
	@Column(name="PRICE_PER_MONTH")
	private double pricePerMonth;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "STATUS_FK")
	private RoomAvailabiltyStatus status;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="HOUSING_FK")
	private Housing house;

	public RoomForRent() {
		super();
	}

	public RoomForRent(int id, double pricePerMonth, Housing house) {
		super();
		this.id = id;
		this.pricePerMonth = pricePerMonth;
		this.house = house;
	}

	public RoomForRent(int id, double pricePerMonth, RoomAvailabiltyStatus status, Housing house) {
		super();
		this.id = id;
		this.pricePerMonth = pricePerMonth;
		this.status = status;
		this.house = house;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	public RoomAvailabiltyStatus getStatus() {
		return status;
	}

	public void setStatus(RoomAvailabiltyStatus status) {
		this.status = status;
	}

	public Housing getHouse() {
		return house;
	}

	public void setHouse(Housing house) {
		this.house = house;
	}

	@Override
	public int hashCode() {
		return Objects.hash(house, id, pricePerMonth, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RoomForRent))
			return false;
		RoomForRent other = (RoomForRent) obj;
		return Objects.equals(house, other.house) && id == other.id
				&& Double.doubleToLongBits(pricePerMonth) == Double.doubleToLongBits(other.pricePerMonth)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "RoomForRent [id=" + id + ", pricePerMonth=" + pricePerMonth + ", status=" + status + 
				 "]";
	}

	
}
