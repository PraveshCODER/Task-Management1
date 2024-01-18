package task.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.management.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
