package io.kielbo.todoapp.controller;

import io.kielbo.todoapp.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class TaskController {
    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
