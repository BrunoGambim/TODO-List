package com.brunogambim.todolist.core.entities;

import java.util.ArrayList;

public class TodoList {

	private Long id;
	private String name;
	private ArrayList<TodoItem> items;
	
	public TodoList(Long id, String name, ArrayList<TodoItem> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<TodoItem> getItems() {
		return items;
	}
}
