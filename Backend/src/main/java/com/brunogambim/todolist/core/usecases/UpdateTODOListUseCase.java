package com.brunogambim.todolist.core.usecases;

import com.brunogambim.todolist.core.entities.TodoList;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class UpdateTODOListUseCase {
	private TodoListRepository todoListRepository;

	public UpdateTODOListUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public void execute(Long id, String name) {
		this.todoListRepository.updateTodoList(new TodoList(id, name));
	}
}
