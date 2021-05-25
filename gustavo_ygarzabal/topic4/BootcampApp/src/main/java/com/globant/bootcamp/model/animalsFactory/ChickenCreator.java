package com.globant.bootcamp.model.animalsFactory;



import com.globant.bootcamp.model.animals.Chicken;
import com.globant.bootcamp.model.enums.EggColor;
import com.globant.bootcamp.model.enums.Gender;

import java.util.ArrayList;

public class ChickenCreator implements AnimalCreator{
    private static final Chicken[] henPool= {   new Chicken(Gender.FEMALE, EggColor.RED),
                                                new Chicken(Gender.FEMALE, EggColor.WHITE)};

    @Override
    public Chicken createAnimal(Gender gender) {
        return new Chicken(gender, randomEggColor());
    }

    public static Chicken getHen (EggColor eggColor){
        return eggColor.equals(EggColor.RED) ? henPool[0] : henPool[1];
    }

    public static EggColor randomEggColor() {
        return (Math.random() < 0.5) ? EggColor.RED : EggColor.WHITE;
    }

    public static ArrayList<Chicken> getHen(EggColor eggColor, int q){
        ArrayList<Chicken> hens = new ArrayList<>();
        Chicken hen = getHen(eggColor);
        for (int i = 0; i< q; i++){
            hens.add(hen);
        }
        return hens;
    }
}
