package com.globant.bootcamp.animals;

import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.abstracts.Bird;
import com.globant.bootcamp.productFactory.EggCreator;

import java.util.ArrayList;
import java.util.Objects;

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
        EggCreator eggCreator = new EggCreator();
        return eggCreator.getEgg(this.eggColor, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chicken chicken = (Chicken) o;
        return eggColor == chicken.eggColor;
    }

}
