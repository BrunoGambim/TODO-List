package com.brunogambim.todolist.api.v1.dtos;

public class CreateTodoListDTO {
	private String name;
	
	public CreateTodoListDTO() {
		
	}

	public CreateTodoListDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
