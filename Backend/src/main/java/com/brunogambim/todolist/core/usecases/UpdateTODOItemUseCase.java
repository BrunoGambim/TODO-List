package com.brunogambim.todolist.core.usecases;

import com.brunogambim.todolist.core.entities.Difficulty;
import com.brunogambim.todolist.core.entities.Priority;
import com.brunogambim.todolist.core.entities.Status;
import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class UpdateTODOItemUseCase {
	private TodoListRepository todoListRepository;

	public UpdateTODOItemUseCase(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}
	
	public void execute(Long id, String name, String description, String priority,
			String difficulty, String status, Long listId) {
		this.todoListRepository.updateTodoItem(
				new TodoItem(id, name, description, Priority.toEnum(priority), Difficulty.toEnum(difficulty), Status.toEnum(status)),
				listId);
	}
}
