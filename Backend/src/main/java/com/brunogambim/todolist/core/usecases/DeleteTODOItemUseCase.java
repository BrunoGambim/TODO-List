package com.brunogambim.todolist.core.usecases;

import com.brunogambim.todolist.core.repository.TodoListRepository;

public class DeleteTODOItemUseCase {
	private TodoListRepository todoListRepository;

	public DeleteTODOItemUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public void execute(Long id, Long listId) {
		this.todoListRepository.deleteTodoItem(id, listId);
	}
}
