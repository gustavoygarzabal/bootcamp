package com.globant.bootcamp.rest.service;


import com.globant.bootcamp.controller.mvc.dto.UserDto;
import com.globant.bootcamp.rest.entity.User;
import com.globant.bootcamp.rest.exception.UserAlreadyExistException;
import com.globant.bootcamp.rest.exception.UserNotFoundException;
import com.globant.bootcamp.rest.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUserById(Long id, User newUser) {

        User userWithThatEmail = userRepository.findOneByEmail(newUser.getEmail()).orElse(null);

        if(userWithThatEmail!=null) {
            if (!userWithThatEmail.getId().equals(id)) {
                logger.debug("trying to update a user to a already existing email");
                throw new UserAlreadyExistException(newUser.getEmail());
            }
        }

        return  userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setAddress(newUser.getAddress());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean existUserByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
