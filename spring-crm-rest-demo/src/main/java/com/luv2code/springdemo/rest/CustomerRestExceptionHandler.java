package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add exception handler
	// customer not found
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleCustomerNotFound(CustomerNotFoundException e) {
		// create CustomerErrorResponse
		CustomerErrorResponse err = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());

		// return response
		return new ResponseEntity(err, HttpStatus.NOT_FOUND);
	}

	// any exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleAllException(Exception e) {
		// create CustomerErrorResponse
		CustomerErrorResponse err = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());

		// return response
		return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
	}


}
