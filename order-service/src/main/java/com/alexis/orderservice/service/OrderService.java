package com.alexis.orderservice.service;

import com.alexis.orderservice.model.Order;
import com.alexis.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestClient productClient;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.productClient = RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findbyId(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public Order create(Order order) {
        productClient
                .get()
                .uri("/api/products/{id}", order.getProductId())
                .retrieve()
                .toBodilessEntity();
        return orderRepository.save(order);
    }
}