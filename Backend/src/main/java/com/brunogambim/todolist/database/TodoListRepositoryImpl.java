package com.brunogambim.todolist.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.entities.TodoList;
import com.brunogambim.todolist.core.repository.TodoListRepository;
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
		return this.listRepository.findById(id).get().toEntity();
	}

	@Override
	public void addList(TodoList list) {
		this.listRepository.save(TodoListModel.fromEntity(list));
	}

	@Override
	public void addItemToAList(TodoItem item, Long listId) {
		TodoListModel list = this.listRepository.findById(listId).get();
		list.getItems().add(TodoItemModel.fromEntity(item));
		this.listRepository.save(list);
	}
}
