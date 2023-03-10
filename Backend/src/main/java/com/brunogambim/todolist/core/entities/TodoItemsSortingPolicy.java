package com.brunogambim.todolist.core.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TodoItemsSortingPolicy {

	public static ArrayList<TodoItem> sort(ArrayList<TodoItem> items){
		ArrayList<TodoItem> result = new ArrayList<TodoItem>(items);
		result = sortByDifficulty(result);
		result = sortByPriority(result);
		result = sortByStatus(result);
		return result;
	}
	
	private static ArrayList<TodoItem> sortByDifficulty(ArrayList<TodoItem> items){
		ArrayList<TodoItem> result = new ArrayList<TodoItem>();
		Map<Difficulty, ArrayList<TodoItem>> map = new HashMap<Difficulty, ArrayList<TodoItem>>();
		for(Difficulty difficulty : Difficulty.values()) {
			map.put(difficulty, new ArrayList<TodoItem>());
		}
		for(TodoItem item : items) {
			map.get(item.getDifficulty()).add(item);
		}
		for(Difficulty difficulty : Difficulty.values()) {
			for(TodoItem item : map.get(difficulty)) {
				result.add(item);
			}
		}
		return result;
	}
	
	private static ArrayList<TodoItem> sortByPriority(ArrayList<TodoItem> items){
		ArrayList<TodoItem> result = new ArrayList<TodoItem>();
		Map<Priority, ArrayList<TodoItem>> map = new HashMap<Priority, ArrayList<TodoItem>>();
		for(Priority priority : Priority.values()) {
			map.put(priority, new ArrayList<TodoItem>());
		}
		for(TodoItem item : items) {
			map.get(item.getPriority()).add(item);
		}
		for(Priority priority : Priority.values()) {
			for(TodoItem item : map.get(priority)) {
				result.add(item);
			}
		}
		return result;
	}
	
	private static ArrayList<TodoItem> sortByStatus(ArrayList<TodoItem> items){
		ArrayList<TodoItem> result = new ArrayList<TodoItem>();
		Map<Status, ArrayList<TodoItem>> map = new HashMap<Status, ArrayList<TodoItem>>();
		for(Status status : Status.values()) {
			map.put(status, new ArrayList<TodoItem>());
		}
		for(TodoItem item : items) {
			map.get(item.getStatus()).add(item);
		}
		for(Status status : Status.values()) {
			for(TodoItem item : map.get(status)) {
				result.add(item);
			}
		}
		return result;
	}
}
