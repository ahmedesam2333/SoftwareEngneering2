package com.TaskMicroservice.Model.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title must not be blank")
    @Size(min = 1, max = 100, message = "Title length must be between 1 and 100 characters")
    private String title;
    private boolean done;
    private Integer userId;
    public Task() {}
    public Task(String title, boolean done, Integer userId) {
        this.title = title;
        this.done = done;
        this.userId = userId;
    }
    public Task(String title) {
        this.title = title;
        this.done = false;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public boolean isDone() {
        return done;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
  public Integer getUserId() {return userId;}
}