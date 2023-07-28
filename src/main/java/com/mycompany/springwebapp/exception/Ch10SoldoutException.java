package com.mycompany.springwebapp.exception;


public class Ch10SoldoutException extends RuntimeException {
	public Ch10SoldoutException() {
		
	}
	
	public Ch10SoldoutException(String message) {
		super(message);
	}
}