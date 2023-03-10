package com.brunogambim.todolist.api.v1.exceptions;

public class InvalidURIParamsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidURIParamsException() {
		super(message());
	}
	
	public InvalidURIParamsException(Throwable cause) {
		super(message(), cause);
	}
	
	private static String message() {
		return "Parâmetros da URI inválidos";
	}
}
