package com.globant.bootcamp.productFactory;

import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggColor;

import java.util.ArrayList;

public class EggCreator {
    private static final Egg[] eggPool = {
            new Egg(EggColor.RED),
            new Egg(EggColor.WHITE)
    };

    public Egg getEgg(EggColor eggColor){
        return EggColor.RED.equals(eggColor) ? eggPool[0] : eggPool[1];
    }

    public ArrayList<Egg> getEgg(EggColor eggColor, int q){
        ArrayList<Egg> eggs = new ArrayList<>();
        Egg egg = getEgg(eggColor);
        for (int i=0; i<q; i++){
            eggs.add(egg);
        }
        return  eggs;
    }
}
