package com.UserMicroservice.Controller;
import com.UserMicroservice.Model.Entity.User;
import com.UserMicroservice.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody User user) {
        User existingUser = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (existingUser != null) {
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PutMapping("/{userId}/email")
    public ResponseEntity<Void> updateUserEmail( @PathVariable Integer userId, @RequestParam("newEmail")  String newEmail) {
        userService.updateUserEmail(userId, newEmail);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{userId}/password")
    public ResponseEntity<Void> updateUserPassword( @PathVariable Integer userId, @RequestParam("newPassword")  String newPassword) {
        userService.updatePassword(userId, newPassword);
        return ResponseEntity.ok().build();
    }
}