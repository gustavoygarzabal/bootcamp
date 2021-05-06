package com.globant.bootcamp.animals;

import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.abstracts.Bird;

import java.util.ArrayList;

public class Chicken extends Bird {
    private String eggColor;

    public Chicken(Gender gender) {
        super(gender);
    }

    public Chicken(Gender gender, String eggColor) {
        super(gender);
        setEggColor(eggColor);
    }
    public String getEggColor() {
        return eggColor;
    }

    public void setEggColor(String eggColor) {
        this.eggColor = eggColor;
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
    public void fly() {
        System.out.println("Mover alitas hasta 15cms");
    }

    @Override
    public void makeSound() {
        System.out.println("Pio Pio");
    }

    public ArrayList<Egg> getEggs(){
        Egg egg1 = new Egg(this);
        Egg egg2 = new Egg(this);
        ArrayList<Egg> eggs=  new ArrayList<Egg>();
        eggs.add(egg1);
        eggs.add(egg2);
        return eggs;
    }
}
