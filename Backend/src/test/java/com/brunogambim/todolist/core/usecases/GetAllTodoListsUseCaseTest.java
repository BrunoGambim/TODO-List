package com.brunogambim.todolist.core.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.brunogambim.todolist.core.entities.Difficulty;
import com.brunogambim.todolist.core.entities.Priority;
import com.brunogambim.todolist.core.entities.Status;
import com.brunogambim.todolist.core.entities.TodoItem;
import com.brunogambim.todolist.core.entities.TodoList;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class GetAllTodoListsUseCaseTest {
	private GetAllTodoListsUseCase useCase;
	private TodoListRepository repository = Mockito.mock(TodoListRepository.class);
	private ArrayList<TodoList> todoLists;
	
	@BeforeEach
	void initUseCase() {
		useCase = new GetAllTodoListsUseCase(repository);
		TodoItem item1 = new TodoItem(1L, "item1", "desc1", Priority.HIGH, Difficulty.EASY, Status.IN_PROGRESS);
		TodoItem item2 = new TodoItem(2L, "item2", "desc2", Priority.MEDIUM, Difficulty.EASY, Status.DONE);
		TodoItem item3 = new TodoItem(3L, "item3", "desc3", Priority.LOW, Difficulty.MODERATE, Status.IN_PROGRESS);
		TodoList list1 = new TodoList(1L, "list1", new ArrayList<TodoItem>(Arrays.asList(item1,item2)));
		TodoList list2 = new TodoList(2L, "list2", new ArrayList<TodoItem>(Arrays.asList(item3)));
		todoLists = new ArrayList<TodoList>(Arrays.asList(list1, list2));
	}
	
	@Test
	void listsAreReturnedWithTheCorrectData() {
		when(repository.getAllLists()).thenReturn(todoLists);
		ArrayList<TodoList> result = useCase.execute();
		assertThat(result).isEqualTo(todoLists);
		assertThat(result.size()).isEqualTo(todoLists.size());
		assertThat(result.get(0).getId()).isEqualTo(todoLists.get(0).getId());
		assertThat(result.get(1).getId()).isEqualTo(todoLists.get(1).getId());
		assertThat(result.get(1).getName()).isEqualTo(todoLists.get(1).getName());
		assertThat(result.get(0).getItems().get(0).getId()).isEqualTo(todoLists.get(0).getItems().get(0).getId());
	}
}
