package com.app.Taskaty.Repository;
import com.app.Taskaty.Model.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer userId);
    Task findByIdAndUser_Id(Integer taskId, Integer userId);
}
