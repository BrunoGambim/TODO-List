package com.brunogambim.todolist.core.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.brunogambim.todolist.core.repository.TodoListRepository;

public class UpdateTODOListUseCaseTest {
	private UpdateTODOListUseCase useCase;
	private TodoListRepository repository = Mockito.mock(TodoListRepository.class);

	@BeforeEach
	void initUseCase() {
		useCase = new UpdateTODOListUseCase(repository);
	}
	
	
	@Test
	void repositoryMethodAreCalledWithTheCorrectParameter() {
		useCase.execute(1L,"list1");
	
		verify(repository).updateTodoList(argThat( x -> {
			assertThat(x).isNotNull();
			assertThat(x.getId()).isEqualTo(1L);
			assertThat(x.getName()).isEqualTo("list1");
			return true;
	    }));
	}
}
