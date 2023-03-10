package com.brunogambim.todolist.core.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
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
import com.brunogambim.todolist.core.exceptions.CannotDeleteAllListsException;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class DeleteTODOListUseCaseTest {
	private DeleteTODOListUseCase useCase;
	private TodoListRepository repository = Mockito.mock(TodoListRepository.class);
	private TodoList list1;
	private TodoList list2;

	@BeforeEach
	void initUseCase() {
		useCase = new DeleteTODOListUseCase(repository);
		TodoItem item1 = new TodoItem(1L, "item1", "desc1", Priority.HIGH, Difficulty.EASY, Status.IN_PROGRESS);
		TodoItem item2 = new TodoItem(2L, "item2", "desc2", Priority.MEDIUM, Difficulty.EASY, Status.DONE);
		TodoItem item3 = new TodoItem(3L, "item3", "desc3", Priority.LOW, Difficulty.MODERATE, Status.IN_PROGRESS);
		list1 = new TodoList(1L, "list1", new ArrayList<TodoItem>(Arrays.asList(item1,item2)));
		list2 = new TodoList(2L, "list2", new ArrayList<TodoItem>(Arrays.asList(item3)));
	}
	
	
	@Test
	void repositoryMethodAreCalledWithTheCorrectParameter() {
		when(repository.getAllLists()).thenReturn(new ArrayList<TodoList>(Arrays.asList(list1, list2)));
		useCase.execute(1L);
	
		verify(repository).deleteTodoList(argThat( x -> {
			assertThat(x).isNotNull();
			assertThat(x).isEqualTo(1L);
			return true;
	    }));
	}
	
	@Test
	void doesNotAllowAllListsToBeDeleted () {
		when(repository.getAllLists()).thenReturn(new ArrayList<TodoList>(Arrays.asList(list1)));
		
		assertThatThrownBy(() -> {
			useCase.execute(1L);
		}).isInstanceOf(CannotDeleteAllListsException.class);
	}
}
