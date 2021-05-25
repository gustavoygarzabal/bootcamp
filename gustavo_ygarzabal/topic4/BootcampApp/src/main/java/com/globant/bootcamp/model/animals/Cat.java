package com.globant.bootcamp.model.animals;

import com.globant.bootcamp.model.abstracts.Animal;
import com.globant.bootcamp.model.enums.Gender;


public class Cat extends Animal<Cat> {

    public Cat(Gender gender) {
        super(gender);
    }

    @Override
    public void makeSound() {
        System.out.println("Miauuuuu");
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
    public Cat gaveBirth() {
        return null;
    }
}
