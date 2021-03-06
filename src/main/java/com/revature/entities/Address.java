package com.revature.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ADDRESS")
@SequenceGenerator(name="id_pk", sequenceName="address_seq", allocationSize = 1)
public class Address {
	
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_pk")
	private int id;
	
	@NotNull
	@Column(name="HOUSE_NUMBER")
	private String houseNumber;
	
	@NotNull
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@NotNull
	@Column(name="CITY")
	private String city;
	
	@NotNull
	@Column(name="STATE")
	private String state;
	
	@NotNull
	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE")
	private String longitude;
	
	@JsonIgnore
	@OneToOne(cascade= {CascadeType.ALL})
	private Housing housing;

	public Address() {
		super();
	}

	public Address(String streetAddress, String city, String state, String zipCode, String latitude, String longitude) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Address(int id, String streetAddress, String city, String state, String zipCode, String latitude,
			String longitude) {
		super();
		this.id = id;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	

	public Address(int id, @NotNull String houseNumber, @NotNull String streetAddress, @NotNull String city,
			@NotNull String state, @NotNull String zipCode, String latitude, String longitude, Housing housing) {
		super();
		this.id = id;
		this.houseNumber = houseNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.housing = housing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public Housing getHousing() {
		return housing;
	}

	public void setHousing(Housing housing) {
		this.housing = housing;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, houseNumber, housing, id, latitude, longitude, state, streetAddress, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(houseNumber, other.houseNumber)
				&& Objects.equals(housing, other.housing) && id == other.id && Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude) && Objects.equals(state, other.state)
				&& Objects.equals(streetAddress, other.streetAddress) && Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNumber=" + houseNumber + ", streetAddress=" + streetAddress + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

	
	
	
}
