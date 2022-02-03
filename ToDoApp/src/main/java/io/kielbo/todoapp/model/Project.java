package io.kielbo.todoapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String description;
	@OneToMany(mappedBy = "project")
	private Set<TaskGroup> groups;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private Set<ProjectSteps> steps;
	
	public Project() {}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public Set<TaskGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<TaskGroup> groups) {
		this.groups = groups;
	}

	public Set<ProjectSteps> getSteps() {
		return steps;
	}

	public void setSteps(Set<ProjectSteps> steps) {
		this.steps = steps;
	}
	
	
	

}
