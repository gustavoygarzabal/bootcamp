package com.globant.bootcamp.model.products;

public interface Product {

    public  boolean isFull();

    public  boolean isNotFull();

    @Override
    public String toString();

    // TODO how to handle the view
    public String toStringForHTML();
}
