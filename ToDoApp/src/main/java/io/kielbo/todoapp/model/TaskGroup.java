package io.kielbo.todoapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasks_group")
public class TaskGroup extends TaskBase{

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private Set<Task> tasks;
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	public TaskGroup() {}

	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}

}
