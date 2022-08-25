package es.cic.curso00.curso00ejerc17.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import es.cic.curso00.curso00ejerc17.exception.ProductoException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { ProductoException.class })
	protected ResponseEntity<Object> handleConflict1(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST,
				request);
	}
	
	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<Object> handleConflict2(RuntimeException ex, WebRequest request) {
		
		StringBuilder bodyOfResponse = new StringBuilder();
		bodyOfResponse.append("Restriccion de la base de datos. ");
		bodyOfResponse.append(ex.getMessage());
		
		return handleExceptionInternal(ex, bodyOfResponse.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST,
				request);
	}
}