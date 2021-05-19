package com.globant.bootcamp.buildings;

import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.roles.Farmer;

public class FarmCreator implements BuildingCreator{
    @Override
    public Farm createBuilding(int capacity) {
        Farm farm = Farm.getInstance();
        farm.setFarmer(new Farmer(Gender.MALE, "Beck Kent"));
        farm.setCapacity(capacity);
        return farm;
    }
}
