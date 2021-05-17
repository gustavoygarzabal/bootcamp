package com.globant.bootcamp.productFactory;

import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggCartonSize;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.products.EggCarton;

import java.util.ArrayList;

public class EggCartonCreator {
    private final int[] MAPLE_DIM = {6,5};
    private final int[] DOZEN_DIM= {2,6};
    private final int[] HALFDOZEN_DIM= {2,3};

    //TODO finish this method
    public EggCarton getEggCarton (EggCartonSize eggCartonSize, EggColor eggColor) {
        EggCarton eggCarton = null;
        int[] cartonValues=null;
        switch (eggCartonSize){
            case MAPLE:
                cartonValues = MAPLE_DIM;
                break;
            case DOZEN:
                cartonValues = DOZEN_DIM;
                break;
            case HALFDOZEN:
                cartonValues = HALFDOZEN_DIM;
                break;
        }
        int capacity = cartonValues[0]*cartonValues[1];
        eggCarton = new EggCarton(capacity);
        eggCarton.setEggs(getArrayOfNulls(capacity));
        eggCarton.setLine(cartonValues[0]);
        eggCarton.setColumn(cartonValues[1]);
        eggCarton.setEggColor(eggColor);

        return eggCarton;
    }

    public ArrayList<Egg> getArrayOfNulls(int n){
        ArrayList<Egg> eggs = new ArrayList<>();
        for (int i=0; i<n; i++) {
            eggs.add(null);
        }
        return  eggs;
    }




}
