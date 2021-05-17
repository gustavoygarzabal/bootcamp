package com.globant.bootcamp.products;

public interface Product {

    public  boolean isFull();

    public int getCapacity();

    public void setCapacity(int capacity);

    //TODO when toString() is finished then this method should be deprecated
    public  void printProduct();

    @Override
    public String toString();
}
