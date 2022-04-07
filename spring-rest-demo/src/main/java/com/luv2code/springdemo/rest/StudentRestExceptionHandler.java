package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorReponse> handleStudentNotFound(StudentNotFoundException e) {
		
		StudentErrorReponse err = new StudentErrorReponse();
		
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorReponse> handleGenericException(Exception e) {
		
		StudentErrorReponse err = new StudentErrorReponse();
		
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

}
