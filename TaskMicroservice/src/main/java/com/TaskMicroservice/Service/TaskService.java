package com.TaskMicroservice.Service;
import com.TaskMicroservice.Model.Entity.Task;
import com.TaskMicroservice.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public Task createTaskForUser(Integer userId, Task task) {
        task.setUserId(userId);
        return taskRepository.save(task);
    }
    public List<Task> getTasksForUser(Integer userId) {
        return taskRepository.findByUserId(userId);
    }
    public Task toggleTaskStatus(Integer userId, Integer taskId) {
        Task task = getTaskByIdAndUserId(taskId, userId);
        task.setDone(!task.isDone());
        return taskRepository.save(task);
    }
    public Task updateTaskTitle(Integer userId, Integer taskId, String newTitle) {
        Task task = getTaskByIdAndUserId(taskId, userId);
        task.setTitle(newTitle);
        return taskRepository.save(task);
    }
    public void deleteTask(Integer userId, Integer taskId) {
        Task task = getTaskByIdAndUserId(taskId, userId);
        taskRepository.deleteById(taskId);
    }
    private Task getTaskByIdAndUserId(Integer taskId, Integer userId) {
        Task task = taskRepository.findByIdAndUserId(taskId, userId);
        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found with ID: " + taskId);
        }
        return task;
    }
}