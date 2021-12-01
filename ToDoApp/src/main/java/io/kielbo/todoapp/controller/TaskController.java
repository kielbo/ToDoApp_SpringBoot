package io.kielbo.todoapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.kielbo.todoapp.model.Task;
import io.kielbo.todoapp.model.TaskRepository;

@RepositoryRestController
public class TaskController {
	private final TaskRepository taskRepository;
	private static final Logger logger = LoggerFactory
			.getLogger(TaskController.class);

	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	@GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
	ResponseEntity<List<Task>> readAllTasks() {
		logger.warn("Exposing all the taska");
		return ResponseEntity.ok(taskRepository.findAll());
	}
	
	@GetMapping(value = "/tasks")
	ResponseEntity<List<Task>> readAllTasks(Pageable page) {
		logger.warn("Custom paging");
		return ResponseEntity.ok(taskRepository.findAll(page).getContent());
	}
}
