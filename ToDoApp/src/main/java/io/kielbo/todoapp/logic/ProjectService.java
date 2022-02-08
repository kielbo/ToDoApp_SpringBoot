package io.kielbo.todoapp.logic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.kielbo.todoapp.TaskConfigurationProperties;
import io.kielbo.todoapp.model.Project;
import io.kielbo.todoapp.model.ProjectRepository;
import io.kielbo.todoapp.model.Task;
import io.kielbo.todoapp.model.TaskGroup;
import io.kielbo.todoapp.model.TaskGroupRepository;
import io.kielbo.todoapp.model.projection.GroupReadModel;

@Service
public class ProjectService {
	TaskGroupRepository groupRepository;
	ProjectRepository projectRepository;
	TaskConfigurationProperties config;

	public ProjectService(TaskGroupRepository groupRepository, ProjectRepository projectRepository,
			TaskConfigurationProperties taskConfig) {
		this.groupRepository = groupRepository;
		this.projectRepository = projectRepository;
		this.config = taskConfig;
	}

	public List<Project> readAll() {
		return projectRepository.findAll();
	}

	public void createProject(Project project) {
		projectRepository.save(project);
	}

	public GroupReadModel createGroup(LocalDateTime deadline, int projectId) {
		if (!config.getTemplate().isAllowMultipleTasks()
				&& groupRepository.existsByDoneIsFalseAndProject_Id(projectId)) {
			throw new IllegalStateException("Only one undone group per project is allowed");
		}
		TaskGroup result = projectRepository.findById(projectId).map(project -> {
			var targetGroup = new TaskGroup();
			targetGroup.setDescription(project.getDescription());
			targetGroup
					.setTasks(
							project.getSteps().stream()
									.map(projectStep -> new Task(projectStep.getDescription(),
											deadline.plusDays(projectStep.getDaysToDeadline())))
									.collect(Collectors.toSet()));
			return targetGroup;
		}).orElseThrow(() -> new IllegalStateException("project not found"));
		return new GroupReadModel(result);

	}

}
