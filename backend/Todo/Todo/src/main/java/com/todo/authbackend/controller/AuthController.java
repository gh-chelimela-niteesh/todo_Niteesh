package com.todo.authbackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.authbackend.model.User;
import com.todo.authbackend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    // POST /register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println("👉 Received register request: " + user.getEmail());

        try {
            Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
            if (existingUser.isPresent()) {
                System.out.println("❌ Email already exists: " + user.getEmail());
                return ResponseEntity.badRequest().body("Email already registered");
            }

            userRepo.save(user);
            System.out.println("✅ User registered: " + user.getEmail());
            return ResponseEntity.ok("User registered successfully");

        } catch (Exception e) {
            System.err.println("💥 Error during registration: " + e.getMessage());
            e.printStackTrace(); // Show full error
            return ResponseEntity.status(500).body("Server error: " + e.getMessage());
        }
    }


    // POST /login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        Optional<User> user = userRepo.findByEmail(loginUser.getEmail());

        if (user.isPresent() && user.get().getPassword().equals(loginUser.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
