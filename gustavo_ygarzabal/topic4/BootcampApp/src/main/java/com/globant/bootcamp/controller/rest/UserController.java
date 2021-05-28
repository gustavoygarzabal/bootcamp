package com.globant.bootcamp.controller.rest;

import com.globant.bootcamp.controller.rest.exception.UserNotFoundException;
import com.globant.bootcamp.model.User;
import com.globant.bootcamp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        userRepository.save(new User("Gustavo", "ygarzabal.gustavo@gmail.com", "Av. Sarmiento", "Client"));
        userRepository.save(new User("John", "john.doe@gmail.com", "Av. Jones", "Client"));
    }

    @GetMapping("/users")
    public List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return  userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setAddress(newUser.getAddress());
                    user.setEmail(newUser.getEmail());
                    user.setRole(newUser.getRole());
                    return userRepository.save(user);
                }).orElseThrow(() ->
                    new UserNotFoundException(id));


    }




}
