package io.kielbo.todoapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasks_group")
public class TaskGroup extends TaskBase{

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private Set<Task> tasks;

	public TaskGroup() {}

	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
