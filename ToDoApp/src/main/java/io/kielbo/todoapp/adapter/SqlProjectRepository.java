package io.kielbo.todoapp.adapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.kielbo.todoapp.model.Project;
import io.kielbo.todoapp.model.ProjectRepository;

@Repository
public interface SqlProjectRepository extends JpaRepository<Project, Integer>, ProjectRepository {
	@Override
	@Query("select distinct p from Project p join fetch p.steps")
	List<Project> findAll();
}
