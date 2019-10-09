package com.revature.exceptions;

public class BadRequest extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private ErrorResponse error;

	public BadRequest() {
		super();
		this.error.setMessage("Bad Request");
		this.error.setStatus(400);
		this.error.setTimestamp(System.currentTimeMillis());
	}
	
	public BadRequest(String msg) {
		super();
		this.error.setMessage(msg);
		this.error.setStatus(400);
		this.error.setTimestamp(System.currentTimeMillis());
	}

	public ErrorResponse getError() {
		return error;
	}
	
}
