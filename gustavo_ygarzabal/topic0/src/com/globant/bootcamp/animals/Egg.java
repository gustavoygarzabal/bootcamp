package com.globant.bootcamp.animals;

import com.globant.bootcamp.abstracts.Animal;

import java.util.Objects;

public class Egg {
    public boolean isFertilze = false;

//    private Animal baby;
    private String eggColor;

    public Egg(Animal animal){
//        this.baby = animal;
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

    public String toString(){
        if (getEggColor().equals("RED")){
            return "(D)";
        }
        if (getEggColor().equals("WHITE")){
            return "(O)";
        }

        //In this case it will never go for this line
        return "(X)";
    }
}
