package io.kielbo.todoapp.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository {
	public List<Task> findAll();
	public Optional<Task> findById(Integer id);
	public Task save(Task entitiy);
	public Page<Task> findAll(Pageable page);

}
