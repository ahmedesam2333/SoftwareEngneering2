package com.app.Taskaty.Model.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title must not be blank")
    @Size(min = 1, max = 255, message = "Title length must be between 1 and 255 characters")
    private String title;
    @NotNull
    private boolean done;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    public Task() {
    }
    public Task(Integer id, String title, boolean done, User user) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.user = user;
    }
    public Task(String title) {
        this.title = title;
        this.done = false;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

