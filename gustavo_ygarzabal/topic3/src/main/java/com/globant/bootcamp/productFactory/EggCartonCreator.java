package com.globant.bootcamp.productFactory;

import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggCartonSize;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.products.EggCarton;

import java.util.ArrayList;

public class EggCartonCreator {
    public static EggCarton getEggCarton (EggCartonSize eggCartonSize, EggColor eggColor) {
        EggCarton eggCarton = new EggCarton(eggColor);
        int capacity = eggCartonSize.getLines() * eggCartonSize.getColumns();
        eggCarton.setEggs(getArrayOfNulls(capacity));
        eggCarton.setLine(eggCartonSize.getLines());
        eggCarton.setColumn(eggCartonSize.getColumns());

        return eggCarton;
    }

    private static ArrayList<Egg> getArrayOfNulls(int n){
        ArrayList<Egg> eggs = new ArrayList<>();
        for (int i=0; i<n; i++) {
            eggs.add(null);
        }
        return  eggs;
    }




}
