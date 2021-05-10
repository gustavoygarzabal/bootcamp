package com.globant.bootcamp.model;

import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;

import java.util.ArrayList;

public class HenFactory {
    private static Chicken[] chickensPool = {   new Chicken(Gender.FEMALE, EggColor.RED),
                                                new Chicken(Gender.FEMALE, EggColor.WHITE)};

    public static Chicken getInstance (EggColor eggColor) {
        return eggColor.equals(EggColor.RED) ? chickensPool[0] : chickensPool[1];
    }
}
