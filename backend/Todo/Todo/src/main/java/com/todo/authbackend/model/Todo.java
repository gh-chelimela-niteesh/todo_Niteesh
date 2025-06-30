package com.todo.authbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String priority;
    private boolean completed;
    private String dueDate;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Todo() {}

    public Todo(String text, String priority, boolean completed, User user) {
        this.text = text;
        this.priority = priority;
        this.completed = completed;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
