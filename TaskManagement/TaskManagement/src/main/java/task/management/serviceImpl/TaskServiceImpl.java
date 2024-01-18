package task.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.management.entity.Task;
import task.management.exception.TaskNotFoundException;
import task.management.repository.TaskRepository;
import task.management.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public Task saveTask(Task task) {
        // Additional logic can be added if needed
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));

        // Update existing task properties
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());

        // Additional logic can be added if needed

        return taskRepository.save(existingTask);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }

        taskRepository.deleteById(id);
    }
}
