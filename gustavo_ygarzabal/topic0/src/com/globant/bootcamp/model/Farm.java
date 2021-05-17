package com.globant.bootcamp.model;

import com.globant.bootcamp.animals.Cat;
import com.globant.bootcamp.animals.Dog;
import com.globant.bootcamp.animals.Duck;
import com.globant.bootcamp.enums.Gender;

import java.util.ArrayList;

public class Farm extends Building {
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private Farmer farmer;
    private ArrayList<Product> products= new ArrayList<Product>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        this.getProducts().add(product);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public Farm(int capacity, Farmer farmer){
        super(capacity);
        this.setFarmer(farmer);
        this.addAllowedAnimal(new Dog(Gender.MALE));
        this.addAllowedAnimal(new Dog(Gender.FEMALE));
        this.addAllowedAnimal(new Cat(Gender.FEMALE));
        this.addAllowedAnimal(new Cat(Gender.MALE));
        this.addAllowedAnimal(new Duck(Gender.FEMALE));
        this.addAllowedAnimal(new Duck(Gender.MALE));
    }

    public ArrayList<Product> work(){
        this.getBuildings().forEach(building -> building.work().forEach(product -> this.addProduct(product)));
        return this.getProducts();
    }

}
