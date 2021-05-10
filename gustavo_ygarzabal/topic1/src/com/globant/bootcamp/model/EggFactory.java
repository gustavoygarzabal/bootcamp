package com.globant.bootcamp.model;

import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;

import java.util.ArrayList;

public class EggFactory {
    private static Egg[] eggsPool = {   new Egg(HenFactory.getInstance(EggColor.RED)),
                                        new Egg(HenFactory.getInstance(EggColor.WHITE))};

    public static Egg getInstance (EggColor eggColor) {
        return eggColor.equals(EggColor.RED) ? eggsPool[0] : eggsPool[1];
    }
}