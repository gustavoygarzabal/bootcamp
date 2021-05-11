package com.globant.bootcamp.buildings;

public class FarmCreator extends BuildingCreator{
    @Override
    public Building createBuilding(int capacity) {
        return Farm.getInstance();
    }
}
