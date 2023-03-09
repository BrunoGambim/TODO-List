package com.brunogambim.todolist.core.usecases;

import com.brunogambim.todolist.core.entities.TodoList;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class CreateANewTodoListUseCase {
	private TodoListRepository todoListRepository;

	public CreateANewTodoListUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public void execute(String name) {
		this.todoListRepository.addList(new TodoList(null, name));
	}
}
