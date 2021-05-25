package com.globant.bootcamp.model.buildings;


import com.globant.bootcamp.model.enums.Gender;
import com.globant.bootcamp.model.roles.Farmer;

public class FarmCreator implements BuildingCreator{
    @Override
    public Farm createBuilding(int capacity) {
        Farm farm = Farm.getInstance();
        farm.setFarmer(new Farmer(Gender.MALE, "Beck Kent"));
        farm.setCapacity(capacity);
        return farm;
    }
}
