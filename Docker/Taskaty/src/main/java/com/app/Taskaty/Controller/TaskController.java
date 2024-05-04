package com.app.Taskaty.Controller;
import com.app.Taskaty.Model.Entity.Task;
import com.app.Taskaty.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users/tasks/{userId}")
@CrossOrigin(origins = "http://localhost:5500")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public ResponseEntity<Task> createTaskForUser(@PathVariable Integer userId, @Valid @RequestBody Task task) {
        Task createdTask = taskService.createTaskForUser(userId, task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Task>> getTasksForUser(@PathVariable Integer userId) {
        List<Task> tasks = taskService.getTasksForUser(userId);
        return ResponseEntity.ok(tasks);
    }
    @PutMapping("/toggle/{taskId}")
    public ResponseEntity<Task> toggleTaskStatus(@PathVariable Integer userId, @PathVariable Integer taskId) {
        Task updatedTask = taskService.toggleTaskStatus(userId, taskId);
        return ResponseEntity.ok(updatedTask);
    }
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTaskTitle(@PathVariable Integer userId, @PathVariable Integer taskId, @Valid @RequestBody Task updatedTask) {
        Task task = taskService.updateTaskTitle(userId, taskId, updatedTask.getTitle());
        return ResponseEntity.ok(task);
    }
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer userId, @PathVariable Integer taskId) {
        taskService.deleteTask(userId, taskId);
        return ResponseEntity.ok().build();
    }
}