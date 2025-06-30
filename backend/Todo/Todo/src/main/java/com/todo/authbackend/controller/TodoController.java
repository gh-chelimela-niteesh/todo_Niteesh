package com.todo.authbackend.controller;

import com.todo.authbackend.model.Todo;
import com.todo.authbackend.model.User;
import com.todo.authbackend.repository.TodoRepository;
import com.todo.authbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoRepository todoRepo;

    @Autowired
    private UserRepository userRepo;

    // GET todos by email
    @GetMapping("/{email}")
    public List<Todo> getTodos(@PathVariable String email) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        return userOpt.map(todoRepo::findByUser).orElse(Collections.emptyList());
    }

    // POST add todo
    @PostMapping("/{email}")
    public ResponseEntity<String> addTodo(@PathVariable String email, @RequestBody Todo todo) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent()) {
            todo.setUser(userOpt.get());
            todoRepo.save(todo);
            return ResponseEntity.ok("Todo added");
        } else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }

    // PUT update todo
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        Optional<Todo> todoOpt = todoRepo.findById(id);
        if (todoOpt.isPresent()) {
            Todo todo = todoOpt.get();
            todo.setText(updatedTodo.getText());
            todo.setPriority(updatedTodo.getPriority());
            todo.setCompleted(updatedTodo.isCompleted());
            todoRepo.save(todo);
            return ResponseEntity.ok("Todo updated");
        }
        return ResponseEntity.badRequest().body("Todo not found");
    }

    // DELETE todo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoRepo.deleteById(id);
        return ResponseEntity.ok("Todo deleted");
    }
}
