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

	public Housing() {
		super();
	}

	public Housing(int id, double description, double pricePerMonth, User user, Address address) {
		super();
		this.id = id;
		this.description = description;
		this.pricePerMonth = pricePerMonth;
		this.user = user;
		this.address = address;
	}

	public Housing(double description, double pricePerMonth, User user, Address address) {
		super();
		this.description = description;
		this.pricePerMonth = pricePerMonth;
		this.user = user;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, description, id, pricePerMonth, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Housing))
			return false;
		Housing other = (Housing) obj;
		return Objects.equals(address, other.address)
				&& Double.doubleToLongBits(description) == Double.doubleToLongBits(other.description) && id == other.id
				&& Double.doubleToLongBits(pricePerMonth) == Double.doubleToLongBits(other.pricePerMonth)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Housing [id=" + id + ", description=" + description + ", pricePerMonth=" + pricePerMonth + ", user="
				+ user + ", address=" + address + "]";
	}
	
	
}
