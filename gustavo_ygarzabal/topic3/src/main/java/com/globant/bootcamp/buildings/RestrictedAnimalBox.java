package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Animal;

import java.util.ArrayList;
import java.util.List;

public class RestrictedAnimalBox extends AnimalBox{
    private List<Animal> allowedAnimals = new ArrayList<>();

    public List<Animal> getAllowedAnimals() {
        return allowedAnimals;
    }

    public void setAllowedAnimals(ArrayList<Animal> allowedAnimals) {
       allowedAnimals.forEach(animal -> addAllowedAnimal(animal));
    }

    public boolean isAllowed(Animal animal){
        return this.getAllowedAnimals().contains(animal);
    }

    @Override
    public void addAnimal(Animal animal){
        if(isAllowedAndNotFull(animal)){
            this.getAnimals().add(animal);
        }
    }

    public void addAllowedAnimal(Animal animal){
        if( !this.allowedAnimals.contains(animal)){
            this.allowedAnimals.add(animal);
        }
    }

    public void removeAllowedAnimal(Animal animal){
        this.getAllowedAnimals().remove(animal);
    }

    public boolean isAllowedAndNotFull(Animal animal){
        return isNotFull() && isAllowed(animal);
    }
}
