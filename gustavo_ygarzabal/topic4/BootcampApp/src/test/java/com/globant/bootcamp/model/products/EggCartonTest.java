package com.globant.bootcamp.model.products;


import com.globant.bootcamp.model.enums.EggCartonSize;
import com.globant.bootcamp.model.enums.EggColor;
import com.globant.bootcamp.model.productFactory.EggCartonCreator;
import com.globant.bootcamp.model.productFactory.EggCreator;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EggCartonTest {
    EggCarton eggCarton;


    @Test
    void addEgg() throws Exception {
        //add a wrong egg
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.HALF_DOZEN, EggColor.RED);
        Exception e = assertThrows(Exception.class, () -> eggCarton.addEgg(EggCreator.getEgg(EggColor.WHITE)));
        assertEquals("You try to add a egg ith a different color", e.getMessage());
        assertFalse(eggCarton.getEggs().contains(EggCreator.getEgg(EggColor.RED)));

        //add a egg with a empty egg
        eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        assertTrue(eggCarton.getEggs().contains(EggCreator.getEgg(EggColor.RED)));

        //add a full carton
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.HALF_DOZEN, EggColor.RED);

        for(int i=0; i < eggCarton.getCapacity(); i++){
            eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        }
        assertEquals(eggCarton.getCapacity(), Collections.frequency(eggCarton.getEggs(),
                                                            EggCreator.getEgg(EggColor.RED)));


    }

    @Test
    void getEggColor() {
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.MAPLE, EggColor.RED);
        assertEquals(EggColor.RED, eggCarton.getEggColor());
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.MAPLE, EggColor.WHITE);
        assertEquals(EggColor.WHITE, eggCarton.getEggColor());
    }

    @Test
    void isOfColor() {
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.MAPLE, EggColor.WHITE);
        assertTrue(eggCarton.isOfColor(EggColor.WHITE));
        assertFalse(eggCarton.isOfColor(EggColor.RED));
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.MAPLE, EggColor.RED);
        assertTrue(eggCarton.isOfColor(EggColor.RED));
    }

    @Test
    void isFull() throws Exception{
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.DOZEN, EggColor.RED);
        assertFalse(eggCarton.isFull());
        for (int i = 0; i < eggCarton.getCapacity()-1; i++) {
            eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        }
        assertFalse(eggCarton.isFull());
        eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        assertTrue(eggCarton.isFull());
    }

    @Test
    void isNotFull() throws Exception{
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.DOZEN, EggColor.RED);
        assertTrue(eggCarton.isNotFull());
        for (int i = 0; i < eggCarton.getCapacity()-1; i++) {
            eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        }
        assertTrue(eggCarton.isNotFull());
        eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        assertFalse(eggCarton.isNotFull());
    }

    @Test
    void testToString() throws Exception{
        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.MAPLE, EggColor.RED);
        for (int i = 0; i <eggCarton.getCapacity(); i++) {
            eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        }
        assertEquals("\n==== RED ====\n(D)(D)(D)(D)(D)\n(D)(D)(D)(D)(D)"+
                "\n(D)(D)(D)(D)(D)\n(D)(D)(D)(D)(D)\n(D)(D)(D)(D)(D)"+
                "\n(D)(D)(D)(D)(D)\n===============",
                eggCarton.toString());

        eggCarton = EggCartonCreator.getEggCarton(EggCartonSize.MAPLE, EggColor.RED);
        for (int i = 0; i <eggCarton.getCapacity()-2; i++) {
            eggCarton.addEgg(EggCreator.getEgg(EggColor.RED));
        }
        assertEquals("\n==== RED ====\n(D)(D)(D)(D)(D)\n(D)(D)(D)(D)(D)"+
                        "\n(D)(D)(D)(D)(D)\n(D)(D)(D)(D)(D)\n(D)(D)(D)(D)(D)"+
                        "\n(D)(D)(D)(G)(G)\n===============",
                eggCarton.toString());
    }
}