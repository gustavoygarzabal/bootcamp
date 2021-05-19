package com.globant.bootcamp.buildings;

import com.globant.bootcamp.products.Product;
import com.globant.bootcamp.roles.Farmer;

import java.util.ArrayList;

public class Farm extends FarmBuilding<Product>{
    private ArrayList<Building> buildings = new ArrayList<Building>();
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
            this.deliverProducts().addAll(building.deliverProducts());
            building.cleanProducts();
        });
    }
}