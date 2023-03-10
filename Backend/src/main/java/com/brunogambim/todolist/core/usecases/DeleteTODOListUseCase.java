package com.brunogambim.todolist.core.usecases;

import com.brunogambim.todolist.core.repository.TodoListRepository;

public class DeleteTODOListUseCase {
	private TodoListRepository todoListRepository;

	public DeleteTODOListUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public void execute(Long id) {
		this.todoListRepository.deleteTodoList(id);
	}
}
