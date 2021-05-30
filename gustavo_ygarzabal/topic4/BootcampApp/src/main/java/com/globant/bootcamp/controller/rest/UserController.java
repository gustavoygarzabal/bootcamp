package com.globant.bootcamp.controller.rest;

import com.globant.bootcamp.controller.rest.exception.UserAlreadyExistException;
import com.globant.bootcamp.controller.rest.exception.UserNotFoundException;
import com.globant.bootcamp.entity.User;
import com.globant.bootcamp.repository.UserRepository;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;

    @Autowired
    public UserController(UserRepository userRepository, UserModelAssembler userModelAssembler) {
        this.userRepository = userRepository;
        this.userModelAssembler = userModelAssembler;
    }


    @GetMapping("")
    public CollectionModel<EntityModel<User>>  all() {
        List<EntityModel<User>> users = userRepository.findAll().stream()
                .map(userModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(users,
                linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @PostMapping("")
    public ResponseEntity<?> newUser(@Valid @RequestBody User newUser){
        newUser.setId(null);
        User user = userRepository.findUserByEmail(newUser.getEmail());
        if(user != null) {
            throw  new UserAlreadyExistException(newUser.getEmail());
        }


        EntityModel<User> entityModel = userModelAssembler.toModel(userRepository.save(newUser));

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/id={id}")
    public EntityModel<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userModelAssembler.toModel(user);
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
