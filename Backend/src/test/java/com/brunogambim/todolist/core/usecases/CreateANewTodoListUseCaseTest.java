package com.brunogambim.todolist.core.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.argThat;

import com.brunogambim.todolist.core.repository.TodoListRepository;

public class CreateANewTodoListUseCaseTest {
	private CreateANewTodoListUseCase useCase;
	private TodoListRepository repository = Mockito.mock(TodoListRepository.class);

	@BeforeEach
	void initUseCase() {
		useCase = new CreateANewTodoListUseCase(repository);
	}
	
	
	@Test
	void repositoryMethodAreCalledWithTheCorrectParameter() {
		useCase.execute("list1");
	
		verify(repository).addList(argThat( x -> {
		      assertThat(x).isNotNull();
		      assertThat(x.getName()).contains("list1");
		      return true;
		    }));
		
		verify(repository).addList(argThat( x -> {
		      assertThat(x).isNotNull();
		      assertThat(x.getName()).doesNotContain("list2");
		      return true;
		    }));
	}
}
