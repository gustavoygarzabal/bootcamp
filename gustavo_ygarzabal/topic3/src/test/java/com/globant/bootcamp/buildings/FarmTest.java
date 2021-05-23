package com.globant.bootcamp.buildings;

import com.globant.bootcamp.enums.EggCartonSize;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.productFactory.EggCartonCreator;
import com.globant.bootcamp.productFactory.EggCreator;
import com.globant.bootcamp.products.EggCarton;
import com.globant.bootcamp.products.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FarmTest {

    @Test
    void work() {
        Building<Product> building1 = Mockito.mock(Building.class);
        List<Product> products1 = Arrays.asList(
                EggCartonCreator.getEggCarton(EggCartonSize.HALF_DOZEN, EggColor.RED),
                EggCartonCreator.getEggCarton(EggCartonSize.DOZEN, EggColor.RED),
                EggCartonCreator.getEggCarton(EggCartonSize.MAPLE, EggColor.RED)
        );

        Building<Product> building2 = Mockito.mock(Building.class);
        List<Product> products2 = new ArrayList<>();
        products2.add(EggCartonCreator.getEggCarton(EggCartonSize.HALF_DOZEN, EggColor.RED));
        try {
            for (int i = 0; i < 6; i++) {
                ((EggCarton)products2.get(0)).addEgg(EggCreator.getEgg(EggColor.RED));
            }
        } catch (Exception e) {

        }



        Mockito.when(building1.getProducts()).thenReturn(products1);
        Mockito.when(building2.getProducts()).thenReturn(products2);
        Farm farm = Farm.getInstance();
        farm.addBuilding(building1);
        farm.addBuilding(building2);
        farm.work();
        assertEquals(4, farm.getProducts().size());

    }
}