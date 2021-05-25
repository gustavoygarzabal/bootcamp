package com.globant.bootcamp.model.interfaces;

public interface Being<T> {
    void breathe();
    void eat();
    void sleep();
    T gaveBirth();
}
