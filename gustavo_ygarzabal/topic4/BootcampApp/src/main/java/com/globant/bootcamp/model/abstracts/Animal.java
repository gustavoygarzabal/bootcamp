package com.globant.bootcamp.model.abstracts;

import com.globant.bootcamp.model.enums.Gender;
import com.globant.bootcamp.model.interfaces.Being;

public abstract class Animal<T> implements Being<T> {
    protected Gender gender;

    public Animal(Gender gender){
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public abstract void makeSound();

    @Override
    public boolean equals(Object animal){
        if (this.getClass() == animal.getClass()){
            return  this.getGender() == ((Animal)animal).getGender();
        }
        return false;
    }

    protected static Gender randomGender()
    {
        return (Math.random() < 0.5) ? Gender.FEMALE : Gender.MALE;
    }
}
