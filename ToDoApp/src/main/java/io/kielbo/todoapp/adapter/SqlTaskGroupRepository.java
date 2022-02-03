package io.kielbo.todoapp.adapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.kielbo.todoapp.model.TaskGroup;
import io.kielbo.todoapp.model.TaskGroupRepository;
@Repository
public interface SqlTaskGroupRepository extends JpaRepository<TaskGroup, Integer>, TaskGroupRepository {

	@Override
	@Query("select distinct g from TaskGroup g join fetch g.tasks")
	List<TaskGroup> findAll();

	@Override
	boolean existsByDoneIsFalseAndProject_Id(Integer id);
	
	
	

}
