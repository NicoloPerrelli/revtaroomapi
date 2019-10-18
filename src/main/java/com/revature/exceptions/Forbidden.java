package com.revature.exceptions;

public class Forbidden extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public Forbidden() {
		super("Resource forbidden.");
	}
	
	public Forbidden(String msg) {
		super(msg);
	}
	
}
