package com.alexis.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID productId;
    private UUID userId;
    private int quantity;
    private String status;
    @CreationTimestamp
    private LocalDateTime createdAt;
}