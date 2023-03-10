package com.brunogambim.todolist.core.usecases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.brunogambim.todolist.core.entities.Difficulty;
import com.brunogambim.todolist.core.entities.Priority;
import com.brunogambim.todolist.core.entities.Status;
import com.brunogambim.todolist.core.repository.TodoListRepository;

public class AddAnItemToAListUseCaseTest {
	private AddAnItemToAListUseCase useCase;
	private TodoListRepository repository = Mockito.mock(TodoListRepository.class);

	@BeforeEach
	void initUseCase() {
		useCase = new AddAnItemToAListUseCase(repository);
	}
	
	
	@Test
	void repositoryMethodAreCalledWithTheCorrectParameter() {
		useCase.execute("item1", "desc1", "high", "moderate", "in progress", 1L);
	
		verify(repository).addItemToAList(argThat( x -> {
				assertThat(x).isNotNull();
				assertThat(x.getName()).isEqualTo("item1");
				assertThat(x.getDescription()).isEqualTo("desc1");
				assertThat(x.getPriority()).isEqualTo(Priority.HIGH);
				assertThat(x.getDifficulty()).isEqualTo(Difficulty.MODERATE);
				assertThat(x.getStatus()).isEqualTo(Status.IN_PROGRESS);
				return true;
		    }),argThat( x -> {
				assertThat(x).isNotNull();
				assertThat(x).isEqualTo(1L);
				return true;
		    }));
	}
}
