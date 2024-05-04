package com.app.Taskaty.Service;
import com.app.Taskaty.Model.Entity.User;
import com.app.Taskaty.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public void updateUserEmail(Integer userId, String newEmail) {
        User user = getUserById(userId);
        user.setEmail(newEmail);
        userRepository.save(user);
    }
    public void updatePassword(Integer userId, String newPassword) {
        User user = getUserById(userId);
        user.setPassword(newPassword);
        userRepository.save(user);
    }
    @Transactional(readOnly = true)
    public User getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null ) {
            return user;
        } else {
            throw new IllegalArgumentException("Invalid email or password");
        }
    }
    private User getUserById(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }
}