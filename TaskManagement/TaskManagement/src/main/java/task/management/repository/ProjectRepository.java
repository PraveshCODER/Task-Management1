package task.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.management.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
