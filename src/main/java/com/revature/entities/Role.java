package com.revature.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
@SequenceGenerator(name="role_pk_gen", sequenceName="role_seq", allocationSize=1)
public class Role {
	
	@Id
	@Column(name="USER_ROLE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int roleId;
	
	@Column(name="USER_ROLE_NAME")
	private String roleName;
	
	
	
	public Role() {
		super();
	}

	public Role(int id) {
		this.roleId = id;
		
		switch(id) {
		case 1:
			roleName = "AMIN";
			break;
		case 2:
			roleName = "DEV";
			break;
		case 3:
			roleName = "USER";
			break;
		default:
			roleName = "LOCKED";
		}
	}

	public Role(String name) {
		this.roleName = name;
		
		switch(name.toUpperCase()) {
		case "ADMIN":
			roleId = 1;
			break;
		case "DEV":
			roleId = 2;
			break;
		case "USER":
			roleId = 3;
			break;
		default:
			roleId = 4;
		}
	}
	

	public int getId() {
		return roleId;
	}

	public void setId(int id) {
		this.roleId = id;
	}

	public String getName() {
		return roleName;
	}

	public void setName(String name) {
		this.roleName = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Role))
			return false;
		Role other = (Role) obj;
		return roleId == other.roleId && Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
	
	
}
