package com.hostbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hostbooks.exceptions.DataNotFoundException;
import com.hostbooks.exceptions.DataNotSavedException;
import com.hostbooks.exceptions.IdNotFoundException;
import com.hostbooks.exceptions.MailNotValidException;
import com.hostbooks.model.ErrorType;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(MailNotValidException.class)
	ResponseEntity<ErrorType> handleConstraintViolationException(MailNotValidException exception) {
		return new ResponseEntity<ErrorType>(new ErrorType(exception.getMessage(), "MAIL NOT VALID ", "Student"),
				HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorType> exception(DataNotFoundException exception) {
		return new ResponseEntity<ErrorType>(new ErrorType(exception.getMessage(), "Data Not Found ", "Student"),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataNotSavedException.class)
	public ResponseEntity<ErrorType> exception(DataNotSavedException exception) {
		return new ResponseEntity<ErrorType>(new ErrorType(exception.getMessage(), "Data Not Saved ", "Student"),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorType> exception(IdNotFoundException exception) {
		return new ResponseEntity<ErrorType>(new ErrorType(exception.getMessage(), "ID NOT FOUND ", "Student"),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorType> exception(RuntimeException exception) {
		return new ResponseEntity<ErrorType>(
				new ErrorType(exception.getMessage(), "Data Not Found (Runtime Exception)", "Student"),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorType> exception(Exception exception) {
		return new ResponseEntity<ErrorType>(
				new ErrorType(exception.getMessage(), "Data Not Found (Exception)", "Student"), HttpStatus.NOT_FOUND);
	}
}
