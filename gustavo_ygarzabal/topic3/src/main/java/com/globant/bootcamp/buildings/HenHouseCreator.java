package com.globant.bootcamp.buildings;

import com.globant.bootcamp.animalsFactory.ChickenCreator;
import com.globant.bootcamp.enums.EggColor;


public class HenHouseCreator implements BuildingCreator{
    @Override
    public HenHouse createBuilding(int capacity) {
        HenHouse henHouse = new HenHouse();
        henHouse.setCapacity(capacity);
        return henHouse;
    }

    public HenHouse createBuilding(int red, int white) {
        HenHouse henHouse = createBuilding(red+white);
        henHouse.addAllowedAnimal(ChickenCreator.getHen(EggColor.RED));
        henHouse.addAllowedAnimal(ChickenCreator.getHen(EggColor.WHITE));
        henHouse.getAnimals().addAll(ChickenCreator.getHen(EggColor.RED,red));
        henHouse.getAnimals().addAll(ChickenCreator.getHen(EggColor.WHITE,white));
        return henHouse;
    }
}
