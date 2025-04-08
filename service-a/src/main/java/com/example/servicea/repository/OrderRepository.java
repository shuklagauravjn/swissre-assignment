package com.example.servicea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servicea.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}