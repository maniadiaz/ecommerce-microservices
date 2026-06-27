package com.alexis.orderservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexis.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}