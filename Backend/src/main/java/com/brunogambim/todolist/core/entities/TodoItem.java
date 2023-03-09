package com.brunogambim.todolist.core.entities;

public class TodoItem {
	private Long id;
	private String name;
	private String description;
	private Priority priority;
	private Difficulty difficulty;
	private Status status;
	
	public TodoItem(Long id, String name, String description, Priority priority, Difficulty difficulty, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.difficulty = difficulty;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Priority getPriority() {
		return priority;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public Status getStatus() {
		return status;
	}
}
