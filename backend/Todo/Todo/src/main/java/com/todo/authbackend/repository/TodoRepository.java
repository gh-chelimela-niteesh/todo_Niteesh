package com.todo.authbackend.repository;

import com.todo.authbackend.model.Todo;
import com.todo.authbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user);
}
