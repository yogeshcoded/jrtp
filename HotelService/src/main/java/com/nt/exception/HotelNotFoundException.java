package com.nt.exception;

public class HotelNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelNotFoundException() {
		super();
		}
	public HotelNotFoundException(String msg) {
		super(msg);
	}
		
	

}
