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

import com.revature.dtos.Principal;

@NamedQueries({
	@NamedQuery(name="getByUsername", query="from User u where u.username = :un"),
	//@NamedQuery(name="findByEmail", query="from user JOIN role USING (roleId) WHERE email = :email"),
	@NamedQuery(name="getUserByCredentials", query="from User u where u.username = :un and u.password = :pw")
})

@Entity
@Table(name="USERS")
@SequenceGenerator(name="id_pk", sequenceName="user_seq", allocationSize = 1)
public class User {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_pk")
	private int id;
	
	@Column(name="FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable = false )
	private String lastName;
	
	@Column(name="USERNAME", unique = true)
	private String username;
	
	@Column(name="EMAIL", unique = true)
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
//	@OneToOne(cascade= {CascadeType.ALL})
//	@JoinColumn(name="USER_PROFILE_FK")
//	private UserProfile profile;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="USER_ROLE_FK")
	private Role role;
	
	
	
	public User() {
		super();
	}
	
	public User(String firstName, String lastName, String username, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(int id, String firstName, String lastName, String username, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public UserProfile getProfile() {
//		return profile;
//	}
//
//	public void setProfile(UserProfile profile) {
//		this.profile = profile;
//	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
public void copyFields(User copy) {
		
		this.email = copy.email;
		this.username = copy.username;
		this.password = copy.password;
		this.role = copy.role;
	}
	public Principal extractPrincipal() {
		return new Principal(this.id, this.username, this.role.toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				//&& Objects.equals(profile, other.profile) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
}
