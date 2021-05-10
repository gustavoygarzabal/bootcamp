package com.globant.bootcamp.animals;

import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.abstracts.Bird;
import com.globant.bootcamp.objectsPools.EggFactory;

import java.util.ArrayList;

//TODO implement that a hen can put any number of eggs
//TODO implement another way of how eggs colors are use

public class Chicken extends Bird {
    private EggColor eggColor;
    public Chicken(Gender gender) {
        super(gender);
    }

    public Chicken(Gender gender, EggColor eggColor) {
        super(gender);
        setEggColor(eggColor);
    }
    public EggColor getEggColor() {
        return eggColor;
    }

    public void setEggColor(EggColor eggColor) {
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

    public ArrayList<Egg> getLaidEggs(){
        ArrayList<Egg> eggs=  new ArrayList<Egg>();
        eggs.add(EggFactory.getInstance(this.eggColor));
        eggs.add(EggFactory.getInstance(this.eggColor));
        return eggs;
    }
}
