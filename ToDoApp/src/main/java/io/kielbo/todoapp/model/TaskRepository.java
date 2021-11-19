package io.kielbo.todoapp.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Override
	@RestResource(exported = false)
	default void deleteById(Integer id) {
	}

	@Override
	@RestResource(exported = false)
	default void delete(Task entity) {
	}

	@RestResource(path = "done", rel = "done")
	List<Task> findByDoneIsTrue();

}
