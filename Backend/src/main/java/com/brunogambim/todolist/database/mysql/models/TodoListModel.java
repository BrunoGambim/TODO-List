package com.brunogambim.todolist.database.mysql.models;

import java.util.ArrayList;
import java.util.List;

import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.entities.TodoList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name = "todo_list")
public class TodoListModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "list_id")
	private List<TodoItemModel> items;
	
	public TodoListModel() {
	}

	public TodoListModel(Long id, String name, ArrayList<TodoItemModel> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}
	
	public static TodoListModel fromEntity(TodoList list) {
		return new TodoListModel(list.getId(), list.getName(),
				new ArrayList<TodoItemModel>(list.getItems().stream().map(item -> TodoItemModel.fromEntity(item)).toList()));
	}
	
	public TodoList toEntity() {
		return new TodoList(this.getId(), this.getName(),
				new ArrayList<TodoItem>(this.getItems().stream().map(item -> item.toEntity()).toList()));
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

	public List<TodoItemModel> getItems() {
		return items;
	}

	public void setItems(List<TodoItemModel> items) {
		this.items = items;
	}
}
