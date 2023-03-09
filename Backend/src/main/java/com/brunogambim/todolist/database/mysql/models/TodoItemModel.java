package com.brunogambim.todolist.database.mysql.models;

import com.brunogambim.todolist.core.entities.Difficulty;
import com.brunogambim.todolist.core.entities.Priority;
import com.brunogambim.todolist.core.entities.Status;
import com.brunogambim.todolist.core.entities.TodoItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "todo_item")
public class TodoItemModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Integer priority;
	private Integer difficulty;
	private Integer status;
	
	
	
	public TodoItemModel() {
	}

	public TodoItemModel(Long id, String name, String description, Integer priority, Integer difficulty,
			Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.difficulty = difficulty;
		this.status = status;
	}
	
	public static TodoItemModel fromEntity(TodoItem item) {
		return new TodoItemModel(item.getId(), item.getName(), item.getDescription(), item.getPriority().getCode(),
				item.getDifficulty().getCode(), item.getStatus().getCode());
	}
	
	public TodoItem toEntity() {
		return new TodoItem(this.getId(), this.getName(), this.getDescription(), Priority.toEnum(this.getPriority()),
				Difficulty.toEnum(this.getDifficulty()), Status.toEnum(this.getStatus()));
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
