package com.globant.bootcamp.model;

import com.globant.bootcamp.enums.Gender;

//TODO the farmer could be the responsable of start the work of the farm

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
