package com.globant.bootcamp.animals;

import com.globant.bootcamp.abstracts.Animal;

import java.util.Objects;

public class Egg {
    private boolean isFertilze = false;
    private String eggColor;


    public Egg(Animal animal){
        this.setEggColor(((Chicken)animal).getEggColor());
    }

    public String getEggColor() {
        return eggColor;
    }

    public void setEggColor(String eggColor) {
        this.eggColor = eggColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Egg egg = (Egg) o;
        return isFertilze == egg.isFertilze && eggColor.equals(egg.eggColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFertilze, eggColor);
    }

    @Override
    public String toString(){
        return (getEggColor().equals("RED"))? "(D)" : "(O)";
    }
}
