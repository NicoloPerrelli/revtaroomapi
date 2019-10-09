package com.revature.exceptions;

public class Unauthorized extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private ErrorResponse error;
	
	public Unauthorized() {
		super();
		this.error.setMessage("Unauthenticated");
		this.error.setStatus(401);
		this.error.setTimestamp(System.currentTimeMillis());
	}
	
	public Unauthorized(String msg) {
		super();
		this.error.setMessage(msg);
		this.error.setStatus(401);
		this.error.setTimestamp(System.currentTimeMillis());
	}

	public ErrorResponse getError() {
		return error;
	}
	
}
