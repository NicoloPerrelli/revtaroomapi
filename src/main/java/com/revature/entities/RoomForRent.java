package com.revature.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROOM_FOR_RENT")
@SequenceGenerator(name="id_pk", sequenceName="room_seq", allocationSize = 1)
public class RoomForRent {
	
	@Id
	@Column(name="ROOM_FOR_RENT_ID")
	private int id;
	
	@Column(name="PRICE_PER_MONTH")
	private double pricePerMonth;
	
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

	public RoomForRent(double pricePerMonth, Housing house) {
		super();
		this.pricePerMonth = pricePerMonth;
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

	public Housing getHouse() {
		return house;
	}

	public void setHouse(Housing house) {
		this.house = house;
	}

	@Override
	public int hashCode() {
		return Objects.hash(house, id, pricePerMonth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RoomForRent))
			return false;
		RoomForRent other = (RoomForRent) obj;
		return Objects.equals(house, other.house) && id == other.id
				&& Double.doubleToLongBits(pricePerMonth) == Double.doubleToLongBits(other.pricePerMonth);
	}

	@Override
	public String toString() {
		return "RoomForRent [id=" + id + ", pricePerMonth=" + pricePerMonth + ", house=" + house + "]";
	}
	
	
	
}
