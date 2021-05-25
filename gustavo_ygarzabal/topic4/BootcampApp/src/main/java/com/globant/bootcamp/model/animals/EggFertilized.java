package com.globant.bootcamp.model.animals;


import com.globant.bootcamp.model.abstracts.Animal;
import com.globant.bootcamp.model.enums.EggColor;

import java.util.Objects;

public class EggFertilized extends Egg{
    private boolean isFertilze = true;

    public EggFertilized(Animal animal) {
        super(animal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EggFertilized egg = (EggFertilized) o;
        return isFertilze == egg.isFertilze && eggColor.equals(egg.eggColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFertilze, eggColor);
    }

    @Override
    public String toString(){
        return (getEggColor().equals(EggColor.RED))? "(D)" : "(O)";
    }
}
