package com.globant.bootcamp.model.roles;


import com.globant.bootcamp.model.enums.Gender;

public class Farmer extends Person {
    public Farmer(Gender gender, String name) {
        super(gender, name);
    }

    public Farmer(Gender gender) {
        super(gender);
    }

    @Override
    public void makeSound() {
        System.out.println("bla bla bla (but like a farmer)");
    }



}
