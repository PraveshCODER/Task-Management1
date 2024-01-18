package task.management.service;

import java.util.List;
import java.util.Optional;

import task.management.entity.Task;

public interface TaskService {
	List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task saveTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
