package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.abstracts.Building;
import com.globant.bootcamp.abstracts.Product;
import com.globant.bootcamp.animals.Cat;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.animals.Dog;
import com.globant.bootcamp.animals.Duck;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.roles.Farmer;
import com.globant.bootcamp.objectsPools.HenFactory;

import java.util.ArrayList;

public class Farm extends Building {
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private Farmer farmer;
    private static Farm farm;

    private Farm() {

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

    public void addBuilding (Building building) {
        this.getBuildings().add(building);
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public static synchronized Farm getInstance() {
        if(farm == null) {
            farm = new Farm();
        }
        return  farm;
    }

    public void work(){
        this.getBuildings().forEach(building -> {
            building.work();
            this.getProducts().addAll(building.getProducts());
            building.cleanProducts();
        });
    }


    //This is a initial approach of what a farm already config could have


    //I consider this program as a simulation of a working program in a particular state with a certain number of
    //building, hens, etc. For that reason I implemented in a way that you can add the functionality that in a current
    //day add, remove or modify anything you want.

    //For that reason the following method just simulate a state as a demo for the program
    public void setDemoConfig(int capacity, Farmer farmer) {
        this.setCapacity(capacity);
        this.setFarmer(farmer);
        this.addAllowedAnimal(new Dog(Gender.MALE));
        this.addAllowedAnimal(new Dog(Gender.FEMALE));
        this.addAllowedAnimal(new Cat(Gender.FEMALE));
        this.addAllowedAnimal(new Cat(Gender.MALE));
        this.addAllowedAnimal(new Duck(Gender.FEMALE));
        this.addAllowedAnimal(new Duck(Gender.MALE));

        //HenHouse creating
        HenHouse henHouse = new HenHouse(40);
        for (int i = 0 ; i < 40*0.7; i++) {
            henHouse.addAnimal(HenFactory.getInstance(EggColor.RED));
        }
        for (int i = 0 ; i < 40*0.3; i++) {
            henHouse.addAnimal(HenFactory.getInstance(EggColor.WHITE));
        }
        //Fisnish the creation of HenHouse

        ArrayList<Building> buildings= new ArrayList<Building>();
        buildings.add(henHouse);
        farm.setBuildings(buildings);

        //I leave this section bus it's not my code, the project already included it, so i think this is
        //the best place to be. Feel free to delete it in any moment

        Animal[] animals = new Animal[4];
        Chicken gallina = new Chicken(Gender.FEMALE);
        Duck pato = new Duck(Gender.MALE);
        Dog doggo = new Dog(Gender.MALE);
        Cat cat = new Cat(Gender.FEMALE);

        animals[0] = gallina;
        animals[1] = pato;
        animals[2] = doggo;
        animals[3] = cat;

        for(Animal animal: animals) {
            farm.getAnimals().add(animal);
        }
    }


}
