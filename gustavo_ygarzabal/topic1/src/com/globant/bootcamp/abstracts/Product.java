package com.globant.bootcamp.abstracts;

abstract public class Product {
    private int capacity;

    public Product(int capacity){
        this.setCapacity(capacity);
    }

    public abstract boolean isFull();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public abstract void printProduct();
}
