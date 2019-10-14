package com.revature.dtos;

import java.util.Objects;

public class Principal {

		
		private int id;
		private String email;
		private String role;
		
		public Principal() {
			super();
		}

		public Principal(int id, String email, String role) {
			super();
			this.id = id;
			this.email = email;
			this.role = role;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public int hashCode() {
			return Objects.hash(email, id, role);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Principal))
				return false;
			Principal other = (Principal) obj;
			return Objects.equals(email, other.email) && id == other.id && Objects.equals(role, other.role);
		}

		@Override
		public String toString() {
			return "Principal [id=" + id + ", email=" + email + ", role=" + role + "]";
		}

		
}
