package com.revature.entities;

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
	
}
