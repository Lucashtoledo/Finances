package com.example.finances.services;

import com.example.finances.entities.User;
import com.example.finances.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> users = repository.findAll();
        return users;
    }
}