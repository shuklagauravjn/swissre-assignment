package com.example.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.servicea.model.Order;
import com.example.servicea.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<String> postOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return new ResponseEntity<>("Order has been created", HttpStatus.CREATED);
    }
}