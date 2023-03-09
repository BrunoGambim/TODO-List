package com.brunogambim.todolist.core.entities;

public enum Priority {
	HIGH(1, "high"),
	MEDIUM(2, "medium"),
	LOW(3, "low");

	private int code;
	private String description;
	
	private Priority(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Priority toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return Priority.toEnum((int) code);
	}
	
	public static Priority toEnum(int code) {
		for(Priority priority :Priority.values()) {
			if(code == priority.getCode()) {
				return priority;
			}
		}
		throw new IllegalArgumentException("Invalid argument! Id:" + code);
	}
}
