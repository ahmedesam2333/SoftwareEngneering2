package com.app.Taskaty.Repository;
import com.app.Taskaty.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
 User findByEmail(String email);
}
