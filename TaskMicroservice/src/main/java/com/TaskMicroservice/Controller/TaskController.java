package com.TaskMicroservice.Controller;
import com.TaskMicroservice.Model.Entity.Task;
import com.TaskMicroservice.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users/tasks/{userId}")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public ResponseEntity<Task> createTaskForUser(@PathVariable Integer userId, @Valid @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTaskForUser(userId, task));
    }
    @GetMapping
    public ResponseEntity<List<Task>> getTasksForUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(taskService.getTasksForUser(userId));
    }
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTaskTitle(@PathVariable Integer userId, @PathVariable Integer taskId, @Valid @RequestBody Task updatedTask) {
        return ResponseEntity.ok(taskService.updateTaskTitle(userId, taskId, updatedTask.getTitle()));
    }
    @PutMapping("/toggle/{taskId}")
    public ResponseEntity<Task> toggleTaskStatus(@PathVariable Integer userId, @PathVariable Integer taskId) {
        return ResponseEntity.ok(taskService.toggleTaskStatus(userId, taskId));
    }
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer userId, @PathVariable Integer taskId) {
        taskService.deleteTask(userId, taskId);
        return ResponseEntity.noContent().build();
    }
}