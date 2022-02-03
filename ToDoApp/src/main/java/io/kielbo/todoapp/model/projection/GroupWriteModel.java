package io.kielbo.todoapp.model.projection;

import java.util.Set;
import java.util.stream.Collectors;

import io.kielbo.todoapp.model.TaskGroup;

public class GroupWriteModel {
	String description;
	private Set<GroupTaskWriteModel> tasks;

	public TaskGroup toGroup() {
		var result = new TaskGroup();
		result.setTasks(tasks.stream().map(GroupTaskWriteModel::toTask).collect(Collectors.toSet()));
		return result;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<GroupTaskWriteModel> getTasks() {
		return tasks;
	}
	public void setTasks(Set<GroupTaskWriteModel> tasks) {
		this.tasks = tasks;
	}
	
	
}
