package com.globant.bootcamp.model;

import com.globant.bootcamp.abstracts.Animal;

import java.util.ArrayList;

abstract public class Building {
    private int capacity=0;
    private ArrayList<Animal> allowedAnimals = new ArrayList<Animal>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Product> products = new ArrayList<Product>();

   public boolean addAnimal(Animal animal){
       if(!isFull() && isAllowed(animal)){
           this.getAnimals().add(animal);
           return true;
       }
       return false;
   }

   public boolean isAllowed(Animal animal){
       return this.getAllowedAnimals().contains(animal);
   }

   public boolean isFull(){
       return !(this.getAnimals().size() < this.getCapacity());
   }

   public void cleanProducts() {
       this.setProducts(new ArrayList<Product>());
   }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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

    public abstract void work();
}
