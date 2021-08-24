package com.example.Market.exception;

public class ProductNotFoundException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;

	public ProductNotFoundException(String message) {
		super();
		this.message = message;
	}

	public ProductNotFoundException() {
		super();
	}

	
}
