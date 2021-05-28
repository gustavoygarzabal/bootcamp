package com.globant.bootcamp.controller.rest;

import com.globant.bootcamp.controller.rest.exception.UserAlreadyExistException;
import com.globant.bootcamp.controller.rest.exception.UserNotFoundException;
import com.globant.bootcamp.model.User;
import com.globant.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        userRepository.save(new User("Gustavo", "ygarzabal.gustavo@gmail.com", "Av. Sarmiento", "Client"));
        userRepository.save(new User("John", "john.doe@gmail.com", "Av. Jones", "Client"));
        userRepository.save(new User("Cinthia", "john.doe@gmail.com", "Av. Jones", "Client"));
    }

    @GetMapping("/users")
    public List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User newUser){
        User user = userRepository.findByName(newUser.getName());
        if(user != null) {
            throw  new UserAlreadyExistException(newUser.getName());
        }
        return userRepository.save(newUser);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/users/name={name}")
    public User getUserByName(@PathVariable String name){
        return userRepository.findByName(name);
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
                }).orElseThrow(() -> new UserNotFoundException(id));

    }




}
