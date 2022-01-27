package io.kielbo.todoapp.logic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import io.kielbo.todoapp.model.Task;
import io.kielbo.todoapp.model.TaskGroupRepository;

public class TempService {
	@Autowired
	List<String> temp(TaskGroupRepository repository) {
		return repository.findAll().stream().flatMap(taskGroup -> taskGroup.getTasks().stream())
				.map(Task::getDescription).collect(Collectors.toList());
		
	}

}
