package com.globant.bootcamp.model.productFactory;


import com.globant.bootcamp.model.animals.Egg;
import com.globant.bootcamp.model.enums.EggColor;

import java.util.ArrayList;

public class EggCreator {
    private static final Egg[] eggPool = {
            new Egg(EggColor.RED),
            new Egg(EggColor.WHITE)
    };

    public static Egg getEgg(EggColor eggColor){
        return EggColor.RED.equals(eggColor) ? eggPool[0] : eggPool[1];
    }

    public static ArrayList<Egg> getEgg(EggColor eggColor, int q){
        ArrayList<Egg> eggs = new ArrayList<>();
        Egg egg = getEgg(eggColor);
        for (int i=0; i<q; i++){
            eggs.add(egg);
        }
        return  eggs;
    }
}
