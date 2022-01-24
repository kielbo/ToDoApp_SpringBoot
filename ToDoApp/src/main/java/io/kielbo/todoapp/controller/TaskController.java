package io.kielbo.todoapp.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.kielbo.todoapp.model.Task;
import io.kielbo.todoapp.model.TaskRepository;

@RestController
public class TaskController {
	private final TaskRepository taskRepository;
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

	public TaskController(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@GetMapping(value = "/tasks", params = { "!sort", "!page", "!size" })
	public ResponseEntity<List<Task>> readAllTasks() {
		logger.warn("Exposing all the taska");
		return ResponseEntity.ok(taskRepository.findAll());
	}

	@GetMapping(value = "/tasks")
	public ResponseEntity<List<Task>> readAllTasks(Pageable page) {
		logger.warn("Custom paging");
		return ResponseEntity.ok(taskRepository.findAll(page).getContent());
	}

	@PutMapping(value = "/tasks/{id}")
	public ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate) {
		if (!taskRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		taskRepository.findById(id).ifPresent(task -> {
			task.updateFrom(toUpdate);
			taskRepository.save(task);
		});
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> getTask(@PathVariable int id) {
		return taskRepository.findById(id).map(task -> ResponseEntity.ok(task))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(value = "/tasks")
	public ResponseEntity<?> createTask(@RequestBody @Valid Task postTask) {
		taskRepository.save(postTask);
		return ResponseEntity.created(URI.create("/" + postTask.getId())).body(postTask);
	}

	@Transactional
	@PatchMapping("/task/{id}")
	public ResponseEntity<?> toggleTask(@PathVariable int id) {
		if (!taskRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		taskRepository.findById(id).ifPresent(task -> task.setDone(!task.isDone()));
		return ResponseEntity.noContent().build();
	}

}
