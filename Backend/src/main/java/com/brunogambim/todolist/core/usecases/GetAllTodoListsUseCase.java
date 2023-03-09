package com.brunogambim.todolist.core.usecases;

import java.util.ArrayList;

import com.brunogambim.todolist.core.entities.TodoList;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class GetAllTodoListsUseCase {
	
	private TodoListRepository todoListRepository;

	public GetAllTodoListsUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public ArrayList<TodoList> execute() {
		return this.todoListRepository.getAllLists();
	}
}
