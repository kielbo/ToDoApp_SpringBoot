package io.kielbo.todoapp.adapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.kielbo.todoapp.model.Task;
import io.kielbo.todoapp.model.TaskRepository;

@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
	List<Task> findByDoneIsTrue();
	
	@Override 
	boolean existsByDoneIsFalseAndGroup_id(Integer groupId);

}
