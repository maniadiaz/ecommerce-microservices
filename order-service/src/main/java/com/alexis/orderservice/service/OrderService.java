package com.alexis.orderservice.service;

import com.alexis.orderservice.model.Order;
import com.alexis.orderservice.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestClient productClient;
    private final RestClient userClient;

    public OrderService(OrderRepository orderRepository,
            @Qualifier("loadBalancedRestClientBuilder") RestClient.Builder restClientBuilder) {
        this.orderRepository = orderRepository;
        this.productClient = restClientBuilder
                .baseUrl("http://PRODUCT-SERVICE")
                .build();
        this.userClient = restClientBuilder
                .baseUrl("http://USER-SERVICE")
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

        userClient
                .get()
                .uri("/api/users/{id}", order.getUserId())
                .retrieve()
                .toBodilessEntity();
        return orderRepository.save(order);
    }
}