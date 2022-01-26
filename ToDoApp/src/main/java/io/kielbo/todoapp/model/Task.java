package io.kielbo.todoapp.model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tasks")
public class Task extends TaskBase{

	private LocalDateTime deadline;
	@Embedded
	private Audit audit = new Audit();
	@ManyToOne(targetEntity = TaskGroup.class)
	@JoinColumn(name = "tasks_group_id")
	private TaskGroup group;

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public Task() {
		/* Empty for spring purpose */ }
	
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
