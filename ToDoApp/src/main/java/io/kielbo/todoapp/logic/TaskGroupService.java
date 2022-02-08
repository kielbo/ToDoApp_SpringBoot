package io.kielbo.todoapp.logic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.kielbo.todoapp.model.TaskGroup;
import io.kielbo.todoapp.model.TaskGroupRepository;
import io.kielbo.todoapp.model.TaskRepository;
import io.kielbo.todoapp.model.projection.GroupReadModel;
import io.kielbo.todoapp.model.projection.GroupWriteModel;

@Service
/**
 * Warstwa pośrednia między modelem a controllerem
 */
public class TaskGroupService {
	TaskGroupRepository groupRepo;
	TaskRepository taskRepo;

	public TaskGroupService(TaskGroupRepository gRepo, TaskRepository tReapo) {
		this.groupRepo = gRepo;
		this.taskRepo = tReapo;
	}

	public GroupReadModel createGroup(GroupWriteModel source) {
		return new GroupReadModel(groupRepo.save(source.toGroup()));
	}

	public List<GroupReadModel> getAll() {
		return groupRepo.findAll().stream().map(GroupReadModel::new).collect(Collectors.toList());
	}

	public void toggleGroup(int id) {
		if (taskRepo.existsByDoneIsFalseAndGroup_id(id)) {
			throw new IllegalStateException("There are still some not finished tasks in the group. Close them first");
		}
		TaskGroup result = groupRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Group not found"));
		result.setDone(!result.isDone());
	}

}
