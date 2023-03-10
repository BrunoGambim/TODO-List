package com.brunogambim.todolist.core.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.brunogambim.todolist.core.repository.TodoListRepository;

public class DeleteTODOItemUseCaseTest {
	private DeleteTODOItemUseCase useCase;
	private TodoListRepository repository = Mockito.mock(TodoListRepository.class);

	@BeforeEach
	void initUseCase() {
		useCase = new DeleteTODOItemUseCase(repository);
	}
	
	
	@Test
	void repositoryMethodAreCalledWithTheCorrectParameter() {
		useCase.execute(1L, 3L);
	
		verify(repository).deleteTodoItem(argThat( x -> {
			assertThat(x).isNotNull();
			assertThat(x).isEqualTo(1L);
			return true;
	    }),argThat( x -> {
			assertThat(x).isNotNull();
			assertThat(x).isEqualTo(3L);
			return true;
	    }));
	}
}
