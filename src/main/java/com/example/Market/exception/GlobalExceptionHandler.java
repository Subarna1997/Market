package com.example.Market.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Market.ApiStatusCode;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(NullPointerException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(ApiStatusCode.NULL_VALUE);
		errorResponse.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ProductNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(ApiStatusCode.PRODUCT_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(OrderNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(ApiStatusCode.ORDER_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNAUTHORIZED);
	}


}
