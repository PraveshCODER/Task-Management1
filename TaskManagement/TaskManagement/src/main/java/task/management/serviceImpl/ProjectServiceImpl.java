package task.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import task.management.entity.Project;
import task.management.exception.ProjectNotFoundException;
import task.management.repository.ProjectRepository;
import task.management.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	 @Autowired
	    private ProjectRepository projectRepository;

	    @Override
	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }

	    @Override
	    public Project getProjectById(Long projectId) {
	        return projectRepository.findById(projectId)
	                .orElseThrow(() -> new ProjectNotFoundException("Project with ID " + projectId + " not found"));
	    }

	    @Override
	    @Transactional
	    public Project saveProject(Project project) {
	        // Additional logic can be added if needed
	        return projectRepository.save(project);
	    }

	    @Override
	    @Transactional
	    public void deleteProject(Long projectId) {
	        projectRepository.deleteById(projectId);
	    }
}
