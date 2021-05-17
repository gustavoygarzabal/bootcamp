package com.globant.bootcamp.animals;

import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.enums.EggColor;

import java.util.Objects;

public class Egg {
    public final EggColor eggColor;

    public Egg(Animal animal){
        this.eggColor=(((Chicken)animal).getEggColor());
    }
    public Egg(EggColor eggColor){
        this.eggColor=eggColor;
    }

    public EggColor getEggColor() {
        return eggColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Egg egg = (Egg) o;
        return eggColor.equals(egg.eggColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eggColor);
    }

    @Override
    public String toString(){
        return (getEggColor().equals(EggColor.RED))? "(D)" : "(O)";
    }
}
