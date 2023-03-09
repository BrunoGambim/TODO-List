package com.brunogambim.todolist.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunogambim.todolist.api.v1.dtos.CreateTodoListDTO;
import com.brunogambim.todolist.api.v1.dtos.GetTodoListDTO;
import com.brunogambim.todolist.core.repository.TodoListRepository;
import com.brunogambim.todolist.core.usecases.CreateANewTodoListUseCase;
import com.brunogambim.todolist.core.usecases.GetAllTodoListsUseCase;

@RestController
@RequestMapping(value = "/v1/todo_lists")
public class TodoListController {
	
	private TodoListRepository todoListRepository;

	@Autowired
	public TodoListController(TodoListRepository todoListRepository) {
		this.todoListRepository = todoListRepository;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<GetTodoListDTO>> getAllTodoLists(){
		GetAllTodoListsUseCase usecase = new GetAllTodoListsUseCase(todoListRepository);
		List<GetTodoListDTO> result = usecase.execute().stream().map(list -> GetTodoListDTO.fromEntity(list)).toList();
		return ResponseEntity.ok().body(result);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> createNewTodoList(@ModelAttribute  CreateTodoListDTO todoListDTO){
		CreateANewTodoListUseCase usecase = new CreateANewTodoListUseCase(todoListRepository);
		usecase.execute(todoListDTO.getName());
		return ResponseEntity.ok().build();
	}
}
