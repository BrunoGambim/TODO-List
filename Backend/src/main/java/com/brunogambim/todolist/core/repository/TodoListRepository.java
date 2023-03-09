package com.brunogambim.todolist.core.repository;

import java.util.ArrayList;

import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.entities.TodoList;

public interface TodoListRepository {
	public ArrayList<TodoList> getAllLists();
	public TodoList getListById(Long id);
	public void addList(TodoList list);
	public void addItemToAList(TodoItem item, Long listId);
}
