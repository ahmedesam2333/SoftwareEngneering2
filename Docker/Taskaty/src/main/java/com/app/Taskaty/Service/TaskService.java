package com.app.Taskaty.Service;
import com.app.Taskaty.Model.Entity.Task;
import com.app.Taskaty.Repository.TaskRepository;
import com.app.Taskaty.Repository.UserRepository;
import com.app.Taskaty.Model.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Transactional
public class TaskService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    public Task createTaskForUser(Integer userId, Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        task.setUser(user);
        return taskRepository.save(task);
    }
    public List<Task> getTasksForUser(Integer userId) {
        return taskRepository.findByUserId(userId);
    }
    public Task toggleTaskStatus(Integer userId, Integer taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + taskId));
        task.setDone(!task.isDone());
        return taskRepository.save(task);
    }
    public Task updateTaskTitle(Integer userId, Integer taskId, String newTitle) {
        Task task = taskRepository.findByIdAndUser_Id(taskId, userId);
        task.setTitle(newTitle);
        return taskRepository.save(task);
    }
    public void deleteTask(Integer userId, Integer taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + taskId));
        taskRepository.deleteById(taskId);
    }
    }