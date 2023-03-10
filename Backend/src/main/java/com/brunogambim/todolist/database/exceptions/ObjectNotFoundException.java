package com.brunogambim.todolist.database.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String identifier, Class<?> classe) {
		super(message(identifier, classe));
	}
	
	public ObjectNotFoundException(String identifier, Class<?> classe, Throwable cause) {
		super(message(identifier, classe), cause);
	}
	
	private static String message(String identifier, Class<?> classe) {
		return "Object no found! Identifier: " + identifier + ", Type: " + classe.getSimpleName();
	}
}
