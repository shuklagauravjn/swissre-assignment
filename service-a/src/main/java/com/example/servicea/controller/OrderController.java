package com.example.servicea.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.servicea.model.Order;
import com.example.servicea.service.OrderService;
import com.example.servicea.model.Notification;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/orders")
    public ResponseEntity<String> postOrder(@RequestBody Order order) {
        // Save the order
        orderService.saveOrder(order);

        // Notify service-b
        String serviceBUrl = "http://localhost:8081/notify"; // URL of service-b

        // Create a Notification object
        Notification notification = new Notification(
            order.getId(), // Use the order ID
            "Order created with ID: " + order.getId(),
            Instant.now() // Current timestamp
        );

        // Send the Notification object as JSON
        ResponseEntity<String> response = restTemplate.postForEntity(serviceBUrl, notification, String.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return new ResponseEntity<>("Order has been created and service-b notified", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Order created but failed to notify service-b", HttpStatus.CREATED);
        }
    }
}