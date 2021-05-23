package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalBox<T extends Animal>{
    private int capacity=0;

    private List<T> animals = new ArrayList<>();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity >= 0 && this.getAnimals().size() <= capacity){
            this.capacity = capacity;
        }
    }

    public List<T> getAnimals() {
        return animals;
    }

    public void setAnimals(List<T> animals) {
        animals.forEach(animal -> this.addAnimal(animal));
    }

    public boolean isNotFull(){
        return this.getAnimals().size() < this.getCapacity();
    }

    public void removeAnimal(T animal){
        this.getAnimals().remove(animal);
    }

    public void addAnimal(T animal){
        if(isNotFull()){
            this.getAnimals().add(animal);
        }
    }

    public int countRepetitions(T animal) {
        return Collections.frequency(this.getAnimals(), animal);
    }

}
