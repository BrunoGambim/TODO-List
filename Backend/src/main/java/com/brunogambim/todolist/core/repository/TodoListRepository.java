package com.brunogambim.todolist.core.repository;

import java.util.ArrayList;

import com.brunogambim.todolist.core.entities.TodoList;

public interface TodoListRepository {
	public ArrayList<TodoList> getAllLists();
}
