package com.brunogambim.todolist.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.entities.TodoList;
import com.brunogambim.todolist.core.repository.TodoListRepository;
import com.brunogambim.todolist.database.exceptions.ObjectNotFoundException;
import com.brunogambim.todolist.database.mysql.models.TodoItemModel;
import com.brunogambim.todolist.database.mysql.models.TodoListModel;
import com.brunogambim.todolist.database.mysql.repositories.MysqlTodoListRepository;

@Service
public class TodoListRepositoryImpl implements TodoListRepository {
	
	private MysqlTodoListRepository listRepository;
	
	@Autowired
	public TodoListRepositoryImpl(MysqlTodoListRepository listRepository) {
		super();
		this.listRepository = listRepository;
	}

	@Override
	public ArrayList<TodoList> getAllLists() {
		return new ArrayList<TodoList>(this.listRepository.findAll().stream().map(listModel -> listModel.toEntity()).toList());
	}

	@Override
	public TodoList getListById(Long id) {
		return this.listRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException(id.toString(), TodoList.class))
				.toEntity();
	}

	@Override
	public void addList(TodoList list) {
		this.listRepository.save(TodoListModel.fromEntity(list));
	}

	@Override
	public void addItemToAList(TodoItem item, Long listId) {
		TodoListModel list = this.listRepository.findById(listId).orElseThrow(
				() -> new ObjectNotFoundException(listId.toString(), TodoList.class));
		list.getItems().add(TodoItemModel.fromEntity(item));
		this.listRepository.save(list);
	}

	@Override
	public void updateTodoItem(TodoItem item, Long listId) {
		TodoListModel list = this.listRepository.findById(listId).orElseThrow(
				() -> new ObjectNotFoundException(listId.toString(), TodoList.class));
		Boolean itemHasBeenUpdated = list.updateItem(TodoItemModel.fromEntity(item));
		if(!itemHasBeenUpdated) {
			throw new ObjectNotFoundException(item.getId().toString(), TodoItem.class);
		}
		this.listRepository.save(list);
	}

	@Override
	public void deleteTodoItem(Long id, Long listId) {
		TodoListModel list = this.listRepository.findById(listId).orElseThrow(
				() -> new ObjectNotFoundException(id.toString(), TodoList.class));
		Boolean itemHasBeenRemoved = list.removeItem(id);
		if(!itemHasBeenRemoved) {
			throw new ObjectNotFoundException(id.toString(), TodoItem.class);
		}
		this.listRepository.save(list);
	}

	@Override
	public void updateTodoList(TodoList list) {
		TodoListModel listModel = this.listRepository.findById(list.getId()).orElseThrow(
				() -> new ObjectNotFoundException(list.getId().toString(), TodoList.class));
		TodoListModel updatedListModel = TodoListModel.fromEntity(list);
		updatedListModel.setItems(listModel.getItems());
		this.listRepository.save(updatedListModel);
	}

	@Override
	public void deleteTodoList(Long id) {
		this.listRepository.deleteById(id);
	}
}
