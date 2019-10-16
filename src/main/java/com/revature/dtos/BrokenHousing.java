package com.revature.dtos;

import com.revature.entities.Address;

public class BrokenHousing {
	
	private String description;
	private double pricePerMonth;
	private Address address;
	private int userId;
	
	public BrokenHousing() {
		super();
	}

	public BrokenHousing(String description, double pricePerMonth, Address address, int userId) {
		super();
		this.description = description;
		this.pricePerMonth = pricePerMonth;
		this.address = address;
		this.userId = userId;
	}

	public BrokenHousing(String description, double pricePerMonth, Address address) {
		super();
		this.description = description;
		this.pricePerMonth = pricePerMonth;
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
