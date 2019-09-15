package com.varnaTravelGuideWeb.exception;

public class InvalidTOTPVerificationCode extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTOTPVerificationCode(String msg) {
		super(msg);
	}
	
	public InvalidTOTPVerificationCode(String msg, Throwable ex) {
		super(msg,ex);
	}
	
}
