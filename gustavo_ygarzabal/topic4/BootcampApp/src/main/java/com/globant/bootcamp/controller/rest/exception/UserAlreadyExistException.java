package com.globant.bootcamp.controller.rest.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String email) {
        super("User already exist with email: "+email);
    }

}
