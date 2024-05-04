package com.app.Taskaty.Controller;
import com.app.Taskaty.Model.Entity.User;
import com.app.Taskaty.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5500")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody User user) {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
public ResponseEntity<?> login(@Valid @RequestBody User user) {
        User existingUser = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser != null) {
                return ResponseEntity.ok(existingUser);
            }
        else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        }
    @PutMapping("/{userId}/email")
    public ResponseEntity<Void> updateUserEmail(@PathVariable Integer userId, @RequestParam("newEmail")  String newEmail) {
        userService.updateUserEmail(userId, newEmail);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{userId}/password")
    public ResponseEntity<Void> updateUserPassword(@PathVariable Integer userId, @RequestParam("newPassword")  String newPassword) {
        userService.updatePassword(userId, newPassword);
        return ResponseEntity.ok().build();
    }
}