package com.globant.bootcamp.buildings;

import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;
import com.globant.bootcamp.productFactory.EggCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HenHouseTest {
    HenHouse henHouse;

    @BeforeEach
    void initClass() {
        HenHouseCreator henHouseCreator = new HenHouseCreator();
        henHouse = henHouseCreator.createBuilding(20,20);
    }

    @Test
    void collectEggsFromAChicken() {

        EggCreator eggCreator = new EggCreator();
        henHouse.collectEggsFromAChicken(new Chicken(Gender.MALE, EggColor.RED), 50);
    }




}