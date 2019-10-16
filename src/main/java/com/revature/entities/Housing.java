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
import javax.validation.constraints.NotNull;

@NamedQueries({
	@NamedQuery(name="getHouseByUserId", query="from Housing h where h.user = :user")

})

@Entity
@Table(name="HOUSING")
@SequenceGenerator(name="id_pk", sequenceName="housing_seq", allocationSize = 1)
public class Housing {
	
	@Id
	@Column(name="HOUSING_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_pk")
	private int id;
	
	@NotNull
	@Column(name="DESCRIPTION")
	private String description;
	@NotNull
	@Column(name="PRICE_PER_MONTH")
	private double pricePerMonth;
	
	@OneToOne(cascade= {CascadeType.ALL})
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_FK")
	private Address address;

	public Housing() {
		super();
	}

	public Housing(int id, String description, double pricePerMonth, User user, Address address) {
		super();
		this.id = id;
		this.description = description;
		this.pricePerMonth = pricePerMonth;
		this.user = user;
		this.address = address;
	}

	public Housing(String description, double pricePerMonth, User user, Address address) {
		super();
		this.description = description;
		this.pricePerMonth = pricePerMonth;
		this.user = user;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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
		return Objects.equals(address, other.address) && Objects.equals(description, other.description)
				&& id == other.id
				&& Double.doubleToLongBits(pricePerMonth) == Double.doubleToLongBits(other.pricePerMonth)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Housing [id=" + id + ", description=" + description + ", pricePerMonth=" + pricePerMonth + ", user="
				+ user + ", address=" + address + "]";
	}

	
	
}
