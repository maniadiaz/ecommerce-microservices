package com.alexis.userservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.alexis.userservice.model.User;
import com.alexis.userservice.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findbyId(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" User not found: " + id));
    }

    public User create(User user){
        return userRepository.save(user);
    }

}
