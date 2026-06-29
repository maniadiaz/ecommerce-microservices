package com.alexis.userservice.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    // Auth
    private String username;
    private String password;
    private String role;
    
    // Perfil
    private String name;
    private int age;
    private String status;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    
}
