package io.kielbo.todoapp.model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Description can not be blank")
	private String description;
	private boolean done;
	private LocalDateTime deadline;
	@Embedded
	private Audit audit = new Audit();
	@ManyToOne
	@JoinColumn(name = "task_group_id")
	private TaskGroup group;

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public Task() {
		/* Empyty for spring purpose */ }

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

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public TaskGroup getGroup() {
		return group;
	}

	public void setGroup(TaskGroup group) {
		this.group = group;
	}

	public void updateFrom(final Task task) {
		description = task.description;
		done = task.done;
		group = task.group;
	}
}
