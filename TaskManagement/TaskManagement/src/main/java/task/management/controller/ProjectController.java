package task.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.management.entity.Project;
import task.management.exception.ProjectNotFoundException;
import task.management.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        try {
            Project project = projectService.getProjectById(id);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (ProjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project) {
        Project savedProject = projectService.saveProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        try {
            projectService.deleteProject(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
