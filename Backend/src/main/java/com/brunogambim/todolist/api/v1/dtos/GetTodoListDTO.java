package com.brunogambim.todolist.api.v1.dtos;

import java.util.ArrayList;

import com.brunogambim.todolist.core.entities.TodoList;

public class GetTodoListDTO {
	private Long id;
	private String name;
	private ArrayList<GetTodoItemDTO> items;
	
	public GetTodoListDTO(Long id, String name, ArrayList<GetTodoItemDTO> items) {
		this.id = id;
		this.name = name;
		this.items = items;
	}
	
	public static GetTodoListDTO fromEntity(TodoList list) {
		return new GetTodoListDTO(list.getId(), list.getName(),
				new ArrayList<GetTodoItemDTO>(list.getItems().stream().map(item -> GetTodoItemDTO.fromEntity(item)).toList()));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<GetTodoItemDTO> getItems() {
		return items;
	}

	public void setItems(ArrayList<GetTodoItemDTO> items) {
		this.items = items;
	}
}
