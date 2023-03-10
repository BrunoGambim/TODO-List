package com.brunogambim.todolist.core.exceptions;

public class CannotDeleteAllListsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CannotDeleteAllListsException() {
		super(message());
	}
	
	public CannotDeleteAllListsException(Throwable cause) {
		super(message(), cause);
	}
	
	private static String message() {
		return "Cannot Delete All Lists";
	}
}
