package com.alexis.userservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexis.userservice.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
