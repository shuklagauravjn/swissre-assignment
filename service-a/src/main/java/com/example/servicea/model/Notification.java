package com.example.servicea.model;

import java.time.Instant;

public class Notification {
    private Long id;
    private String message;
    private String timestamp;

    // Constructor
    public Notification(Long id, String message, Instant timestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp.toString(); // Convert Instant to ISO 8601 string
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}