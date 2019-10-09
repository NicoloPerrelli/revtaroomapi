package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HOUSING")
@SequenceGenerator(name="id_pk", sequenceName="housing_seq", allocationSize = 1)
public class Housing {
	
	@Id
	@Column(name="HOUSING_ID")
	private int id;
	
	@Column(name="DESCRIPTION")
	private double description;
	
	@Column(name="PRICE_PER_MONTH")
	private double pricePerMonth;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="USER_FK")
	private User user;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="address_FK")
	private Address address;
	
}
