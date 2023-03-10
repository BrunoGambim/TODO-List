package com.brunogambim.todolist.core.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TodoItemsSortingPolicyTest {
	@Test
	void itemsAreSortedCorrectly() {
		TodoItem item1 = new TodoItem(1L, "item1", "desc1", Priority.HIGH, Difficulty.MODERATE, Status.TODO);
		TodoItem item2 = new TodoItem(2L, "item2", "desc2", Priority.MEDIUM, Difficulty.MODERATE, Status.DONE);
		TodoItem item3 = new TodoItem(3L, "item3", "desc3", Priority.LOW, Difficulty.MODERATE, Status.IN_PROGRESS);
		TodoItem item4 = new TodoItem(4L, "item1", "desc1", Priority.HIGH, Difficulty.HARD, Status.IN_PROGRESS);
		TodoItem item5 = new TodoItem(5L, "item2", "desc2", Priority.MEDIUM, Difficulty.HARD, Status.TODO);
		TodoItem item6 = new TodoItem(6L, "item3", "desc3", Priority.LOW, Difficulty.HARD, Status.DONE);
		TodoItem item7 = new TodoItem(7L, "item1", "desc1", Priority.HIGH, Difficulty.EASY, Status.DONE);
		TodoItem item8 = new TodoItem(8L, "item2", "desc2", Priority.MEDIUM, Difficulty.EASY, Status.IN_PROGRESS);
		TodoItem item9 = new TodoItem(9L, "item3", "desc3", Priority.LOW, Difficulty.EASY, Status.TODO);
		ArrayList<TodoItem> result = TodoItemsSortingPolicy.sort(new ArrayList<TodoItem>(Arrays.asList(item1, item2, item3, item4,
				item5, item6, item7, item8, item9)));
		assertThat(result.size()).isEqualTo(9);
		for(int i = 0; i < result.size(); i++) {
			for(int j = 0; j < result.size(); j++) {
				TodoItem a = result.get(i);
				TodoItem b = result.get(i);
				assertThat(a.getStatus().getCode() < b.getStatus().getCode() 
						|| (a.getStatus().getCode() == b.getStatus().getCode() 
						&& (a.getPriority().getCode() < b.getPriority().getCode() 
							|| (a.getPriority().getCode() == b.getPriority().getCode()
								&& (a.getDifficulty().getCode() <= b.getDifficulty().getCode()))))).isTrue();
			}
		}
	}
}
