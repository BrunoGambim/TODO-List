package com.brunogambim.todolist.core.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.brunogambim.todolist.core.repository.TodoListRepository;

public class DeleteTODOListUseCaseTest {
	private DeleteTODOListUseCase useCase;
	private TodoListRepository repository = Mockito.mock(TodoListRepository.class);

	@BeforeEach
	void initUseCase() {
		useCase = new DeleteTODOListUseCase(repository);
	}
	
	
	@Test
	void repositoryMethodAreCalledWithTheCorrectParameter() {
		useCase.execute(1L);
	
		verify(repository).deleteTodoList(argThat( x -> {
			assertThat(x).isNotNull();
			assertThat(x).isEqualTo(1L);
			return true;
	    }));
	}
}
