package com.brunogambim.todolist.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunogambim.todolist.api.v1.dtos.CreateTodoItemDTO;
import com.brunogambim.todolist.api.v1.dtos.CreateTodoListDTO;
import com.brunogambim.todolist.api.v1.dtos.GetTodoItemDTO;
import com.brunogambim.todolist.api.v1.dtos.GetTodoListDTO;
import com.brunogambim.todolist.api.v1.dtos.UpdateTodoItemDTO;
import com.brunogambim.todolist.core.repository.TodoListRepository;
import com.brunogambim.todolist.core.usecases.AddAnItemToAListUseCase;
import com.brunogambim.todolist.core.usecases.CreateANewTodoListUseCase;
import com.brunogambim.todolist.core.usecases.DeleteTODOItemUseCase;
import com.brunogambim.todolist.core.usecases.DeleteTODOListUseCase;
import com.brunogambim.todolist.core.usecases.GetAllItemsOfAListUseCase;
import com.brunogambim.todolist.core.usecases.GetAllTodoListsUseCase;
import com.brunogambim.todolist.core.usecases.UpdateTODOItemUseCase;
import com.brunogambim.todolist.core.usecases.UpdateTODOListUseCase;

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
	public ResponseEntity<Void> createNewTodoList(@RequestBody  CreateTodoListDTO todoListDTO){
		CreateANewTodoListUseCase usecase = new CreateANewTodoListUseCase(todoListRepository);
		usecase.execute(todoListDTO.getName());
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateTodoList(@PathVariable Long id, @RequestBody  UpdateTodoItemDTO todoListDTO){
		UpdateTODOListUseCase usecase = new UpdateTODOListUseCase(todoListRepository);
		usecase.execute(id, todoListDTO.getName());
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> updateTodoList(@PathVariable Long id){
		DeleteTODOListUseCase usecase = new DeleteTODOListUseCase(todoListRepository);
		usecase.execute(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}/items", method = RequestMethod.GET)
	public ResponseEntity<List<GetTodoItemDTO>> getAllItemsOfATodoList(@PathVariable Long id){
		GetAllItemsOfAListUseCase usecase = new GetAllItemsOfAListUseCase(todoListRepository);
		List<GetTodoItemDTO> result = usecase.execute(id).stream().map(list -> GetTodoItemDTO.fromEntity(list)).toList();
		return ResponseEntity.ok().body(result);
	}
	
	@RequestMapping(value = "/{id}/items", method = RequestMethod.POST)
	public ResponseEntity<Void> addANewItemInAList(@PathVariable Long id, @RequestBody  CreateTodoItemDTO todoItemDTO){
		AddAnItemToAListUseCase usecase = new AddAnItemToAListUseCase(todoListRepository);
		usecase.execute(todoItemDTO.getName(), todoItemDTO.getDescription(), todoItemDTO.getPriority(),
				todoItemDTO.getDifficulty(), todoItemDTO.getStatus(), id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}/items", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateTODOItem(@PathVariable Long id, @RequestBody  UpdateTodoItemDTO todoItemDTO){
		UpdateTODOItemUseCase usecase = new UpdateTODOItemUseCase(todoListRepository);
		usecase.execute(todoItemDTO.getId(), todoItemDTO.getName(), todoItemDTO.getDescription(), todoItemDTO.getPriority(),
				todoItemDTO.getDifficulty(), todoItemDTO.getStatus(), id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{listId}/items/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTODOItem(@PathVariable Long listId, @PathVariable Long id){
		DeleteTODOItemUseCase usecase = new DeleteTODOItemUseCase(todoListRepository);
		usecase.execute(id, listId);
		return ResponseEntity.ok().build();
	}
}
