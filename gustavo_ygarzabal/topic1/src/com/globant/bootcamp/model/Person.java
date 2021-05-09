package com.globant.bootcamp.model;

import com.globant.bootcamp.abstracts.Human;
import com.globant.bootcamp.enums.Gender;

public class Person extends Human {
    private String name;


    public Person(Gender gender, String name) {
        super(gender);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Gender gender) {
        super(gender);
    }

    @Override
    public void makeSound() {
        System.out.println("bla bla bla");
    }

    @Override
    public void breathe() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public Human gaveBirth() {
        return null;
    }

    @Override
    public void think() {

    }
}
