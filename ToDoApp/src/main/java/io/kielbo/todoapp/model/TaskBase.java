package io.kielbo.todoapp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class TaskBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@NotBlank(message = "Description can not be blank")
	protected String description;
	protected boolean done;
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
	
	
	
}
