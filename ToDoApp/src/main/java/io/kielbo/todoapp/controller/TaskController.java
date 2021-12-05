package io.kielbo.todoapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.kielbo.todoapp.model.Task;
import io.kielbo.todoapp.model.TaskRepository;

@RestController
public class TaskController {
	private final TaskRepository taskRepository;
	private static final Logger logger = LoggerFactory
			.getLogger(TaskController.class);

	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	@GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
	public ResponseEntity<List<Task>> readAllTasks() {
		logger.warn("Exposing all the taska");
		return ResponseEntity.ok(taskRepository.findAll());
	}
	
	@GetMapping(value = "/tasks")
	public ResponseEntity<List<Task>> readAllTasks(Pageable page) {
		logger.warn("Custom paging");
		return ResponseEntity.ok(taskRepository.findAll(page).getContent());
	}
	@GetMapping(value = "/tasks/{id}")
	public ResponseEntity<?> updateTask(@RequestBody @Valid Task toUpdate){
		taskRepository.save(toUpdate);
		return ResponseEntity.noContent().build();
	}
}
