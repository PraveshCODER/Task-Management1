package task.management.service;

import java.util.List;

import task.management.entity.Project;

public interface ProjectService {
	List<Project> getAllProjects();

    Project getProjectById(Long projectId);

    Project saveProject(Project project);

    void deleteProject(Long projectId);
}
