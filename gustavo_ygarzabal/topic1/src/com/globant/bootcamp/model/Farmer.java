package com.globant.bootcamp.model;

import com.globant.bootcamp.enums.Gender;

public class Farmer extends Persona{
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
