package io.kielbo.todoapp.controller;

import io.kielbo.todoapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@RepositoryRestController
public class TaskController {
    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @GetMapping(value = "/tasks", params = {"!sort","!page","!size"})
    ResponseEntity<?> readAllTasks(){
    	logger.warn("Exposing all the taska");
    	return ResponseEntity.ok(taskRepository.findAll());

    }
}
