package com.globant.bootcamp.model.buildings;


import com.globant.bootcamp.model.animals.Egg;
import com.globant.bootcamp.model.animalsFactory.ChickenCreator;
import com.globant.bootcamp.model.enums.EggCartonSize;
import com.globant.bootcamp.model.enums.EggColor;
import com.globant.bootcamp.model.productFactory.EggCartonCreator;
import com.globant.bootcamp.model.productFactory.EggCreator;
import com.globant.bootcamp.model.products.EggCarton;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HenHouseTest {
    HenHouse henHouse;


    @Test
    void work() {
        HenHouseCreator henHouseCreator = new HenHouseCreator();
        henHouse = henHouseCreator.createBuilding(1,30);
        henHouse.setEggCartonSize(EggCartonSize.HALF_DOZEN);
        henHouse.work();
        assertEquals(11, henHouse.getProducts().size());
        int redCartons = 0;
        int whiteCartons = 0;
        for (EggCarton product : henHouse.getProducts()) {
            if (product.getEggColor().equals(EggColor.RED)){
                redCartons++;
            } else  {
                whiteCartons++;
            }
        }
        assertEquals(1, redCartons);
        assertEquals(10, whiteCartons);
    }

    @Test
    void collectEggsFromAChicken() {
        henHouse = new HenHouse();
        List<Egg> eggs = new ArrayList<>();
        eggs.add(EggCreator.getEgg(EggColor.RED));
        eggs.add(EggCreator.getEgg(EggColor.RED));
        assertEquals(eggs, henHouse.collectEggsFromAChicken(ChickenCreator.getHen(EggColor.RED),2));
    }

    @Test
    void addEggToCarton() {
        henHouse = new HenHouse();
        henHouse.setEggCartonSize(EggCartonSize.HALF_DOZEN);
        List<Egg> eggs = new ArrayList<>();
        for (int i = 0; i <6; i++) {
            eggs.add(EggCreator.getEgg(EggColor.WHITE));
        }
        henHouse.addEggToCarton(eggs);
        assertEquals(eggs, henHouse.getProducts().get(0).getEggs());
        assertEquals(6, henHouse.getProducts().get(0).getEggs().size());

        eggs = new ArrayList<>();
        for (int i = 0; i <2; i++) {
            eggs.add(EggCreator.getEgg(EggColor.WHITE));
        }
        henHouse.addEggToCarton(eggs);
        for (int i = 0; i <4; i++) {
            eggs.add(null);
        }
        assertEquals(eggs, henHouse.getProducts().get(1).getEggs());
    }

    @Test
    void getLastNotFullCartonOfSameType() {
        henHouse = new HenHouse();
        henHouse.setEggCartonSize(EggCartonSize.HALF_DOZEN);
        EggCarton expectedEggCarton = EggCartonCreator.getEggCarton(EggCartonSize.HALF_DOZEN, EggColor.RED);

        assertEquals(expectedEggCarton,
                    henHouse.getLastNotFullCartonOfSameType(EggCreator.getEgg(EggColor.RED)));

        List<Egg> eggs = new ArrayList<>();
        for (int i = 0; i <6; i++) {
            eggs.add(EggCreator.getEgg(EggColor.RED));
        }
        henHouse.addEggToCarton(eggs);
        henHouse.getLastNotFullCartonOfSameType(EggCreator.getEgg(EggColor.RED));

        assertEquals(1,
                henHouse.getProducts().indexOf(
                        henHouse.getLastNotFullCartonOfSameType(EggCreator.getEgg(EggColor.RED)))
        );

        henHouse.getLastNotFullCartonOfSameType(EggCreator.getEgg(EggColor.WHITE));
        assertEquals(henHouse.getProducts().get(2),
                henHouse.getLastNotFullCartonOfSameType(EggCreator.getEgg(EggColor.WHITE)));
    }
}