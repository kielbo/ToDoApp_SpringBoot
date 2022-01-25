package io.kielbo.todoapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "task_group")
public class TaskGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	@NotBlank(message = "Task group's descripction can not be blank")
	private String description;
	private boolean done;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private Set<Task> tasks;

	public TaskGroup() {}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}
	
	
	

	

}
