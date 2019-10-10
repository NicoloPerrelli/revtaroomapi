package com.revature.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
@SequenceGenerator(name="id_pk", sequenceName="address_seq", allocationSize = 1)
public class Address {
	
	@Id
	@Column(name="ADDRESS_ID")
	private int id;
	
	@Column(name="STREET_NAME")
	private String streetName;
	
	@Column(name="HOUSE_NUMBER")
	private String houseNumber;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private String longitude;

	public Address() {
		super();
	}

	public Address(int id, String streetName, String houseNumber, String city, String state, String zipCode,
			String latitude, String longitude) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Address(String streetName, String houseNumber, String city, String state, String zipCode, String latitude,
			String longitude) {
		super();
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, houseNumber, id, latitude, longitude, state, streetName, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(houseNumber, other.houseNumber) && id == other.id
				&& Objects.equals(latitude, other.latitude) && Objects.equals(longitude, other.longitude)
				&& Objects.equals(state, other.state) && Objects.equals(streetName, other.streetName)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetName=" + streetName + ", houseNumber=" + houseNumber + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
	
	
	
	
}
