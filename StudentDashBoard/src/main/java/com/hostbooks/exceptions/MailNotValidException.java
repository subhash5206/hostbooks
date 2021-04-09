package com.hostbooks.exceptions;

public class MailNotValidException extends RuntimeException {

	/**
	 * 
	 */
	public String msg;
	private static final long serialVersionUID = 1L;

	public MailNotValidException() {
		super();
	}

	public MailNotValidException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
		this.msg=msg;
	}
	
	
	public String toString()
	{
		return getClass().getName()+" : "+msg;
	}
	
	

}
