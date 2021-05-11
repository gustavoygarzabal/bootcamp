package com.globant.bootcamp.buildings;

import com.globant.bootcamp.AnimalsFactory.ChickenCreator;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.enums.EggColor;

public class HenHouseCreator extends BuildingCreator{
    @Override
    public Building createBuilding(int capacity) {
        HenHouse henHouse = new HenHouse();
        henHouse.setCapacity(capacity);
        return henHouse;
    }

    public Building createBuilding(int red, int white) {
        HenHouse henHouse = (HenHouse) createBuilding(red+white);
        henHouse.addAllowedAnimal((Chicken) ChickenCreator.getHen(EggColor.RED));
        henHouse.addAllowedAnimal((Chicken) ChickenCreator.getHen(EggColor.WHITE));
        henHouse.getAnimals().addAll(ChickenCreator.getHen(EggColor.RED,red));
        henHouse.getAnimals().addAll(ChickenCreator.getHen(EggColor.WHITE,white));
        return henHouse;
    }
}
