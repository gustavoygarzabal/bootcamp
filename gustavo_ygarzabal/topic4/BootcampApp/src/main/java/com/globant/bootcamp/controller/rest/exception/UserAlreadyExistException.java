package com.globant.bootcamp.controller.rest.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String name) {
        super("User already exist with name: "+name);
    }

}
