package com.globant.bootcamp.controller.rest;

import com.globant.bootcamp.controller.rest.exception.UserAlreadyExistException;
import com.globant.bootcamp.controller.rest.exception.UserNotFoundException;
import com.globant.bootcamp.entity.User;
import com.globant.bootcamp.repository.UserRepository;
import org.apache.log4j.Logger;
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
    static final Logger logger = Logger.getLogger(UserController.class.getName());

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
        User user = userRepository.findOneByEmail(newUser.getEmail()).orElse(null);
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
    public CollectionModel<EntityModel<User>> getUserByName(@PathVariable String name){
        List<EntityModel<User>> users = userRepository.findUserByName(name).stream()
                .map(userModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(users,
                linkTo(methodOn(UserController.class).all()).withSelfRel());

    }

    @GetMapping("/email={email}")
    public EntityModel<User> getUserByEmail(@PathVariable String email){
        User user = userRepository.findOneByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
        return userModelAssembler.toModel(user);
    }

    @PutMapping("/id={id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User newUser, @PathVariable Long id) {
        EntityModel<User> entityModel = userModelAssembler.toModel(userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setAddress(newUser.getAddress());
                    user.setEmail(newUser.getEmail());
                    user.setRole(newUser.getRole());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id)));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel)
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

    //TODO should i log when try to delete a non existing user?
    @DeleteMapping("/email={email}")
    public ResponseEntity<?> deleteUserByEmail (@PathVariable String email) {
        User user = userRepository.findOneByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
        userRepository.delete(user);
        return ResponseEntity.noContent().build();

    }




}
