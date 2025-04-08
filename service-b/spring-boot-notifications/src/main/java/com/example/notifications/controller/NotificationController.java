package com.example.notifications.controller;

import com.example.notifications.model.Notification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @PostMapping
    public ResponseEntity<Notification> notify(@RequestBody Notification notification) {
        // Simulate processing the notification
        notification.setTimestamp(String.valueOf(System.currentTimeMillis()));

        // Return the notification object as a JSON response
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }
}