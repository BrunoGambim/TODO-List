package com.brunogambim.todolist.core.usecases;

import java.util.List;

import com.brunogambim.todolist.core.entities.TodoList;
import com.brunogambim.todolist.core.exceptions.CannotDeleteAllListsException;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class DeleteTODOListUseCase {
	private TodoListRepository todoListRepository;

	public DeleteTODOListUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public void execute(Long id) {
		List<TodoList> lists = todoListRepository.getAllLists();
		if(lists.size() < 2) {
			throw new CannotDeleteAllListsException();
		}
		this.todoListRepository.deleteTodoList(id);
	}
}
