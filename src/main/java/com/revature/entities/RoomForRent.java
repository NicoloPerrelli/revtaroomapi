package com.revature.entities;

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
	
}
