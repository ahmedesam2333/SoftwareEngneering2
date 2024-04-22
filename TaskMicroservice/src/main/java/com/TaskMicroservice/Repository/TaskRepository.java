package com.TaskMicroservice.Repository;

import com.TaskMicroservice.Model.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer userId);
    Task findByIdAndUserId(Integer taskId, Integer userId);
}