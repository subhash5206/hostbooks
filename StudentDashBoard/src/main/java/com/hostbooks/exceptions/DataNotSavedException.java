package com.hostbooks.exceptions;

public class DataNotSavedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotSavedException(String msg) {
		super(msg);
	}

	public DataNotSavedException() {
		super();
	}
}
