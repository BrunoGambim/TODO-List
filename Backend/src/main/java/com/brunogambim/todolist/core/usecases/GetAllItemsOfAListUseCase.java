package com.brunogambim.todolist.core.usecases;

import java.util.ArrayList;

import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.entities.TodoItemsSortingPolicy;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class GetAllItemsOfAListUseCase {
	private TodoListRepository todoListRepository;

	public GetAllItemsOfAListUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public ArrayList<TodoItem> execute(Long id) {
		return TodoItemsSortingPolicy.sort(this.todoListRepository.getListById(id).getItems());
	}
}
