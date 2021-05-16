package com.globant.bootcamp.buildings;

public class FarmCreator implements BuildingCreator{
    @Override
    public Farm createBuilding(int capacity) {
        Farm farm = Farm.getInstance();
        farm.setCapacity(capacity);
        return farm;
    }
}
