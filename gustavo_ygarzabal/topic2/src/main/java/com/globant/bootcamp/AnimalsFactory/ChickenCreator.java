package com.globant.bootcamp.AnimalsFactory;

import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.enums.EggColor;
import com.globant.bootcamp.enums.Gender;

import java.util.ArrayList;

public class ChickenCreator extends AnimalCreator{
    private static final Chicken[] henPool= {   new Chicken(Gender.FEMALE, EggColor.RED),
                                                new Chicken(Gender.FEMALE, EggColor.WHITE)};

    @Override
    public Animal createAnimal(Gender gender) {
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
