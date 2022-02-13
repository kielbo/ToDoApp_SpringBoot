package io.kielbo.todoapp.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.kielbo.todoapp.TaskConfigurationProperties;
import io.kielbo.todoapp.model.TaskGroupRepository;

class ProjectServiceTest {

	@Test
	@DisplayName("powinien wyrzucić bląd z powodu ustawień wielu grup i grup niezakończonych ")
	void createGroup_noMultipleGroupConfig_andUndoneGroupExists_throwig_illegalState() {
		// given
		var mockRepository = Mockito.mock(TaskGroupRepository.class);
		when(mockRepository.existsByDoneIsFalseAndProject_Id(anyInt())).thenReturn(true);
		// and
		var mockTemplate = Mockito.mock(TaskConfigurationProperties.Template.class);
		when(mockTemplate.isAllowMultipleTasks()).thenReturn(false);
		// and
		var mockProprties = mock(TaskConfigurationProperties.class);
		when(mockProprties.getTemplate()).thenReturn(mockTemplate);
		// system under test
		var cut = new ProjectService(mockRepository, null, mockProprties);
		// when
		// then
		var exception = catchThrowable(() -> {
			cut.createGroup(LocalDateTime.now(), 10);
		});
		assertThat(exception).isInstanceOf(IllegalStateException.class).hasMessage("Only one undone group per project is allowed");

	}

}
