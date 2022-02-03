package io.kielbo.todoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects_steps")
public class ProjectSteps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String description;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	int daysToDeadline;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getDaysToDeadline() {
		return daysToDeadline;
	}
	public void setDaysToDeadline(int daysToDeadline) {
		this.daysToDeadline = daysToDeadline;
	}
	public int getId() {
		return id;
	}

}
