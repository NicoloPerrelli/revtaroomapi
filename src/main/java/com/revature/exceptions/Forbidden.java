package com.revature.exceptions;

public class Forbidden extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ErrorResponse error;
	
	public Forbidden() {
		super();
		this.error.setMessage("Resource Forbidden");
		this.error.setStatus(403);
		this.error.setTimestamp(System.currentTimeMillis());
	}
	
	public Forbidden(String msg) {
		super();
		this.error.setMessage(msg);
		this.error.setStatus(403);
		this.error.setTimestamp(System.currentTimeMillis());
	}

	public ErrorResponse getError() {
		return error;
	}
	
}
