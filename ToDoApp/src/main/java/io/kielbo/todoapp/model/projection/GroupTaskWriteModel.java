package io.kielbo.todoapp.model.projection;

import java.time.LocalDateTime;

import io.kielbo.todoapp.model.Task;

public class GroupTaskWriteModel {
	String description;
	LocalDateTime deadline;
	
	public Task toTask() {
		return new Task(description, deadline);
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
	
	
	

}
