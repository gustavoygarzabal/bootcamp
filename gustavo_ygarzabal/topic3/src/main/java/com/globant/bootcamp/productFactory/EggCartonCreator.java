package com.globant.bootcamp.productFactory;

import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggCartonSize;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.products.EggCarton;

import java.util.ArrayList;

public class EggCartonCreator {
    //TODO finish this method
    public EggCarton getEggCarton (EggCartonSize eggCartonSize, EggColor eggColor) {
        EggCarton eggCarton = null;
        EggCartonSize cartonSize=null;
        switch (eggCartonSize){
            case MAPLE:
                cartonSize = EggCartonSize.MAPLE;
                break;
            case DOZEN:
                cartonSize = EggCartonSize.DOZEN;
                break;
            case HALFDOZEN:
                cartonSize = EggCartonSize.HALFDOZEN;
                break;
        }
        int capacity = cartonSize.getLines() * cartonSize.getColumns();
        eggCarton = new EggCarton(capacity, eggColor);
        eggCarton.setEggs(getArrayOfNulls(capacity));
        eggCarton.setLine(cartonSize.getLines());
        eggCarton.setColumn(cartonSize.getColumns());

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
