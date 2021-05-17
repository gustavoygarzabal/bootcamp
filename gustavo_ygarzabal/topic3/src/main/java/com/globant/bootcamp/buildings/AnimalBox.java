package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Animal;

import java.util.ArrayList;
import java.util.Collections;

public class AnimalBox {
    private int capacity=0;

    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity >= 0 && this.getAnimals().size() <= capacity){
            this.capacity = capacity;
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        animals.forEach(animal -> this.addAnimal(animal));
    }

    public boolean isNotFull(){
        return this.getAnimals().size() < this.getCapacity();
    }

    public void removeAnimal(Animal animal){
        this.getAnimals().remove(animal);
    }

    public void addAnimal(Animal animal){
        if(isNotFull()){
            this.getAnimals().add(animal);
        }
    }

    public int countRepetitions(Animal animal) {
        return Collections.frequency(this.getAnimals(), animal);
    }

}
