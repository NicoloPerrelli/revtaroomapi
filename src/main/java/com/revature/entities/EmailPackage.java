package com.revature.entities;

public class EmailPackage {

	private String username;
	private String email;
	private String emailText;

	public EmailPackage() {
		super();
	}

	public EmailPackage(String username, String email, String emailText) {
		super();
		this.username = username;
		this.email = email;
		this.emailText = emailText;
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

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailText == null) ? 0 : emailText.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailPackage other = (EmailPackage) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailText == null) {
			if (other.emailText != null)
				return false;
		} else if (!emailText.equals(other.emailText))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmailPackage [username=" + username + ", email=" + email + ", emailText=" + emailText + "]";
	}

}
