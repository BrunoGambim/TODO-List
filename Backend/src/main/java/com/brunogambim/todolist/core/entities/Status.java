package com.brunogambim.todolist.core.entities;

public enum Status {
	IN_PROGRESS(1, "in progress"),
	TODO(2, "todo"),
	DONE(3, "done");

	private int code;
	private String description;
	
	private Status(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Status toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return Status.toEnum((int) code);
	}
	
	public static Status toEnum(int code) {
		for(Status status : Status.values()) {
			if(code == status.getCode()) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid argument! Id:" + code);
	}
}
