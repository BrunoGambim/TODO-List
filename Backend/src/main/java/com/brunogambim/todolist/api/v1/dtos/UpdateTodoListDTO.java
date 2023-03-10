package com.brunogambim.todolist.api.v1.dtos;

public class UpdateTodoListDTO {
	private String name;
	
	public UpdateTodoListDTO() {
		
	}

	public UpdateTodoListDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
