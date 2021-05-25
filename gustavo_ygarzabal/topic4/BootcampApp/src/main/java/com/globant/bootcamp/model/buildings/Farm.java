package com.globant.bootcamp.model.buildings;


import com.globant.bootcamp.model.abstracts.Animal;
import com.globant.bootcamp.model.products.Product;
import com.globant.bootcamp.model.roles.Farmer;

import java.util.ArrayList;

public class Farm extends FarmBuildingWithAnimals<Animal, Product> {
    private ArrayList<Building> buildings = new ArrayList<>();
    private Farmer farmer;
    private static Farm farm;

    private Farm() {
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
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

    @Override
    public void work() {
        this.getBuildings().forEach(building -> {
            building.work();
            this.getProducts().addAll(building.getProducts());
            building.cleanProducts();
        });
    }
}