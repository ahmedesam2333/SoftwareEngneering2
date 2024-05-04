package com.app.Taskaty.Model.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, max = 20, message = "Password length must be between 6 and 20 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,20}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one digit")
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
    public User() {
    }
    public User(Integer id, String email, String password, List<Task> tasks) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.tasks = tasks;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}