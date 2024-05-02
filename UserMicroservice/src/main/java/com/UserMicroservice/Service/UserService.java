package com.UserMicroservice.Service;
import com.UserMicroservice.Model.Entity.User;
import com.UserMicroservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
    }
    private User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }
}