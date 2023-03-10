package com.brunogambim.todolist.database;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public void updateTodoItem(TodoItem item, Long listId) {
		TodoListModel list = this.listRepository.findById(listId).get();
		List<TodoItemModel> listItems = list.getItems();
		for(int i = 0; i < listItems.size(); i++) {
			if(listItems.get(i).getId() == item.getId()) {
				listItems.remove(i);
				listItems.add(TodoItemModel.fromEntity(item));
			}
		}
		this.listRepository.save(list);
	}

	@Override
	public void deleteTodoItem(Long id, Long listId) {
		TodoListModel list = this.listRepository.findById(listId).get();
		List<TodoItemModel> listItems = list.getItems();
		for(int i = 0; i < listItems.size(); i++) {
			if(listItems.get(i).getId() == id) {
				listItems.remove(i);
			}
		}
		this.listRepository.save(list);
	}

	@Override
	public void updateTodoList(TodoList list) {
		TodoListModel listModel = this.listRepository.findById(list.getId()).get();
		TodoListModel updatedListModel = TodoListModel.fromEntity(list);
		updatedListModel.setItems(listModel.getItems());
		this.listRepository.save(updatedListModel);
	}

	@Override
	public void deleteTodoList(Long id) {
		this.listRepository.deleteById(id);
	}
}
