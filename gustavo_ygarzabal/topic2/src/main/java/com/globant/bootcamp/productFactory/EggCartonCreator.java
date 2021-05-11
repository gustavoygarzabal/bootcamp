package com.globant.bootcamp.productFactory;

import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggCartonSize;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.products.EggCarton;

import java.util.ArrayList;

public class EggCartonCreator {

    public EggCarton getEggCarton (EggCartonSize eggCartonSize, EggColor eggColor) {
        EggCarton eggCarton = null;
        if (eggCartonSize.equals(EggCartonSize.MAPLE)) {
            eggCarton = new EggCarton(30);
            eggCarton.setEggs(getArrayOfNulls(30));
            eggCarton.setLine(6);
            eggCarton.setColumn(5);
            eggCarton.setEggColor(eggColor);
        }
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
