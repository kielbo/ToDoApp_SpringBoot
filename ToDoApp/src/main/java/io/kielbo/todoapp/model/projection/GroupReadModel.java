package io.kielbo.todoapp.model.projection;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import io.kielbo.todoapp.model.Task;
import io.kielbo.todoapp.model.TaskGroup;

public class GroupReadModel {
	String description;
	/**
	 *  deadline of a latest Task 
	 */
	LocalDateTime deadline;
	Set<GrouppTaskReaderModel> tasks;
	
	
	public GroupReadModel(TaskGroup source ) {
		this.description = source.getDescription();
		source.getTasks().stream().map(Task::getDeadline).max(LocalDateTime::compareTo)
		.ifPresent(data -> this.deadline = data);
		this.tasks = source.getTasks().stream().map(GrouppTaskReaderModel::new).collect(Collectors.toSet());
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}
	public Set<GrouppTaskReaderModel> getTasks() {
		return tasks;
	}
	public void setTasks(Set<GrouppTaskReaderModel> tasks) {
		this.tasks = tasks;
	}
	
	

}
