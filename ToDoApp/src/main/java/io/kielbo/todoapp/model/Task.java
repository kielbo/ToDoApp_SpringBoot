package io.kielbo.todoapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	private int id;
	private String description;
	private boolean done;
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
