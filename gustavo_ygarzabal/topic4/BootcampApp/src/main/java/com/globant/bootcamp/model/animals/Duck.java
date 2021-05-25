package com.globant.bootcamp.model.animals;


import com.globant.bootcamp.model.abstracts.Bird;
import com.globant.bootcamp.model.enums.Gender;
import com.globant.bootcamp.model.interfaces.Aquatic;

public class Duck extends Bird implements Aquatic {

    public Duck(Gender gender) {
        super(gender);
    }

    @Override
    public void swing() {

    }

    @Override
    public void walk() {

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
    public Egg gaveBirth() {
        return new Egg(new Duck(Gender.MALE));
    }

    @Override
    public void makeSound() {
        System.out.println("Quack Quack Quack...");
    }
}
