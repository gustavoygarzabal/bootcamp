package com.globant.bootcamp.model.buildings;


import com.globant.bootcamp.model.abstracts.Animal;

import java.util.ArrayList;
import java.util.List;

public class RestrictedAnimalBox<T extends Animal> extends AnimalBox<T>{
    private List<T> allowedAnimals = new ArrayList<>();

    public List<T> getAllowedAnimals() {
        return allowedAnimals;
    }

    public void setAllowedAnimals(List<T> allowedAnimals) {
       allowedAnimals.forEach(animal -> addAllowedAnimal(animal));
    }

    public boolean isAllowed(T animal){
        return this.getAllowedAnimals().contains(animal);
    }

    @Override
    public void addAnimal(T animal){
        if(isAllowedAndNotFull(animal)){
            this.getAnimals().add(animal);
        }
    }

    public void addAllowedAnimal(T animal){
        if( !this.allowedAnimals.contains(animal)){
            this.allowedAnimals.add(animal);
        }
    }

    public void removeAllowedAnimal(T animal){
        this.getAllowedAnimals().remove(animal);
    }

    public boolean isAllowedAndNotFull(T animal){
        return isNotFull() && isAllowed(animal);
    }
}
