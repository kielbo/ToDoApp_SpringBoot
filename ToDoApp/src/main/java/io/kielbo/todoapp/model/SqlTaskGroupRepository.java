package io.kielbo.todoapp.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlTaskGroupRepository extends JpaRepository<TaskGroup, Integer>, TaskGroupRepository {

}
