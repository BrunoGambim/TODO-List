package com.brunogambim.todolist.api.v1.exception_handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brunogambim.todolist.core.exceptions.CannotDeleteAllListsException;
import com.brunogambim.todolist.database.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException objectNotFoundException, 
			HttpServletRequest httpServletRequest){
		StandartError standartError = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Not found",
				objectNotFoundException.getMessage(), httpServletRequest.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
	}
	
	@ExceptionHandler(CannotDeleteAllListsException.class)
	public ResponseEntity<StandartError> objectNotFound(CannotDeleteAllListsException objectNotFoundException, 
			HttpServletRequest httpServletRequest){
		StandartError standartError = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Bad request",
				objectNotFoundException.getMessage(), httpServletRequest.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
	}
}
