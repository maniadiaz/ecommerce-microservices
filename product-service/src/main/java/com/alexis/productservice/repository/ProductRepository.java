package com.alexis.productservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexis.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}