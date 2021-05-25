package com.globant.bootcamp.model.productFactory;


import com.globant.bootcamp.model.animals.Egg;
import com.globant.bootcamp.model.enums.EggCartonSize;
import com.globant.bootcamp.model.enums.EggColor;
import com.globant.bootcamp.model.products.EggCarton;

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
