package com.hostbooks.exceptions;

public class BranchNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BranchNotFoundException(String msg) {
		super(msg);
	}

	public BranchNotFoundException() {
		super();
	}

}
