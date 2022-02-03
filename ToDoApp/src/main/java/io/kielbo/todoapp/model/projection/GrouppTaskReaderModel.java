package io.kielbo.todoapp.model.projection;

import io.kielbo.todoapp.model.Task;

public class GrouppTaskReaderModel {
	String description;
	boolean done;
	public GrouppTaskReaderModel(Task source) {
		this.description = source.getDescription(); 
		this.done = source.isDone();
	}
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

}
