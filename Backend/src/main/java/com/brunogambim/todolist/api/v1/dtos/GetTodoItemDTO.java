package com.brunogambim.todolist.api.v1.dtos;

import com.brunogambim.todolist.core.entities.TodoItem;

public class GetTodoItemDTO {
	private Long id;
	private String name;
	private String description;
	private String priority;
	private String difficulty;
	private String status;
	
	public GetTodoItemDTO(Long id, String name, String description, String priority, String difficulty, String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.difficulty = difficulty;
		this.status = status;
	}
	
	public static GetTodoItemDTO fromEntity(TodoItem item) {
		return new GetTodoItemDTO(item.getId(), item.getName(), item.getDescription(), item.getPriority().getDescription(),
				item.getDifficulty().getDescription(), item.getStatus().getDescription());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
