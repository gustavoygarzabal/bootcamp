package com.globant.bootcamp.controller.rest.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Couldn't find a product with id: "+ id);
    }
}
