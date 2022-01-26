package io.kielbo.todoapp.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
	List<Task> findByDoneIsTrue();
	
	@Override 
	boolean existsByDoneIsFalseAndGroup_id(Integer groupId);

}
