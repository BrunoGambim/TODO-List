package com.brunogambim.todolist.core.entities;

public enum Difficulty {
	EASY(1, "easy"),
	MODERATE(2, "moderate"),
	HARD(3, "hard");	

	private int code;
	private String description;
	
	private Difficulty(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Difficulty toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return Difficulty.toEnum((int) code);
	}
	
	public static Difficulty toEnum(int code) {
		for(Difficulty difficulty :Difficulty.values()) {
			if(code == difficulty.getCode()) {
				return difficulty;
			}
		}
		throw new IllegalArgumentException("Invalid argument! Id:" + code);
	}
}
