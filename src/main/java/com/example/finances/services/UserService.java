package com.example.finances.services;

import com.example.finances.entities.User;
import com.example.finances.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> users = repository.findAll();
        return users;
    }
    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();// A chamada de user.get() pode lançar uma exceção caso o usuário não seja encontrado
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public User save(User user) {
        repository.save(user);
        return user;
    }
    public User update(Long id, User user) {
        Optional<User> updatedUser = repository.findById(id);
        if (updatedUser.isPresent()) {
            updatedUser.get().setName(user.getName());
            updatedUser.get().setEmail(user.getEmail());
            updatedUser.get().setSalary(user.getSalary());
            return repository.save(updatedUser.get());
        }
        throw new EntityNotFoundException("User not found");
    }
}
