package com.example.finances.control;

import com.example.finances.entities.User;
import com.example.finances.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService Service;

    @GetMapping
    //ResponseEntity é uma classe do Spring Framework que representa a resposta HTTP completa
    private ResponseEntity<List<User>> getAllUsers() {
        List<User> users = Service.findAll();

        //O método body() é utilizado para definir o corpo da resposta
        //O método ok() cria uma resposta HTTP com o status 200 OK
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = Service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        Service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    private ResponseEntity<Void> createUser(@RequestBody User user) {
        Service.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    private ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User user) {
        Service.update(id, user);
        return ResponseEntity.ok().build();
    }

}
