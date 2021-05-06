package com.globant.bootcamp.model;

import com.globant.bootcamp.abstracts.Animal;

import java.util.ArrayList;

abstract public class Building {
    private int capacity=0;
    private ArrayList<Animal> allowedAnimals = new ArrayList<Animal>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();

   public void addAnimal(Animal animal){
       if(this.getAnimals().size() < this.getCapacity() && this.getAllowedAnimals().contains(animal)){
           this.getAnimals().add(animal);
       }
   }

   public void removeAnimal(Animal animal){
       this.getAnimals().remove(animal);
   }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public Building(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addAllowedAnimal(Animal animal){
        this.allowedAnimals.add(animal);
    }


    public void removeAllowedAnimal(Animal animal){
        this.getAllowedAnimals().remove(animal);
    }

    public ArrayList<Animal> getAllowedAnimals() {
        return allowedAnimals;
    }

    public void setAllowedAnimals(ArrayList<Animal> allowedAnimals) {
        this.allowedAnimals = allowedAnimals;
    }

    public abstract ArrayList<Product> work();
}
