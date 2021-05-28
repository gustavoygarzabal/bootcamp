package com.globant.bootcamp.controller.rest;

import com.globant.bootcamp.controller.rest.exception.UserAlreadyExistException;
import com.globant.bootcamp.controller.rest.exception.UserNotFoundException;
import com.globant.bootcamp.entity.User;
import com.globant.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

//        userRepository.save(new User("Gustavo", "ygarzabal.gustavo@gmail.com", "Av. Sarmiento", "Client"));
//        userRepository.save(new User("John", "john.doe@gmail.com", "Av. Jones", "Client"));
//        userRepository.save(new User("Cinthia", "cinthia@gmail.com", "Av. Jones", "Client"));
    }


    @GetMapping("/")
    public List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User newUser(@RequestBody User newUser){
        User user = userRepository.findUserByEmail(newUser.getEmail());
        if(user != null) {
            throw  new UserAlreadyExistException(newUser.getEmail());
        }
        return userRepository.save(newUser);
    }

    @GetMapping("/id={id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/name={name}")
    public List<User> getUserByName(@PathVariable String name){
        return userRepository.findUserByName(name);
    }

    @GetMapping("/email={email}")
    public User getUserByEmail(@PathVariable String email){
        return userRepository.findUserByEmail(email);
    }

    @PutMapping("/id={id}")
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
