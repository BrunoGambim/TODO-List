package com.brunogambim.todolist.core.usecases;

import com.brunogambim.todolist.core.entities.Difficulty;
import com.brunogambim.todolist.core.entities.Priority;
import com.brunogambim.todolist.core.entities.Status;
import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class AddAnItemToAListUseCase {
	private TodoListRepository todoListRepository;

	public AddAnItemToAListUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public void execute(String name, String description, String priority, String difficulty, String status, Long id) {
		this.todoListRepository.addItemToAList(
				new TodoItem(null, name, description, Priority.toEnum(priority), Difficulty.toEnum(difficulty), Status.toEnum(status))
				, id);
	}
}
