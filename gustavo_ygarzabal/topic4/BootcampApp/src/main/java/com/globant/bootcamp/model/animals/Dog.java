package com.globant.bootcamp.model.animals;


import com.globant.bootcamp.model.abstracts.Animal;
import com.globant.bootcamp.model.enums.Gender;
import com.globant.bootcamp.model.interfaces.Terrestrial;

public class Dog extends Animal<Dog> implements Terrestrial {

    public Dog(Gender gender) {
        super(gender);
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
    public Dog gaveBirth() {
        return null;
    }

    @Override
    public void walk() {

    }

    @Override
    public void makeSound() {
        System.out.println("Guauuu Guauuuu...");
    }
}
