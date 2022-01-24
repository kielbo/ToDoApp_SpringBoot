package io.kielbo.todoapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Description can not be blank")
	private String description;
	private boolean done;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	
	public Task() { /* Empyty for spring purpose */ }
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
	
	public void updateFrom(final Task task) {
		description = task.description;
		done = task.done;
	}
	
	@PrePersist
	void prePersist() {
		createdOn = LocalDateTime.now();
	}
	@PreUpdate
	void preMerge() {
		updatedOn= LocalDateTime.now();
	}


}
