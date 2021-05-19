package com.globant.bootcamp.buildings;

import com.globant.bootcamp.enums.EggCartonSize;
import com.globant.bootcamp.productFactory.EggCartonCreator;
import com.globant.bootcamp.productFactory.EggCreator;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.products.EggCarton;
import com.globant.bootcamp.products.Product;

import java.util.ArrayList;

public class HenHouse extends FarmBuilding<EggCarton> {
    //TODO implement were set this attribute or use it
    private EggCartonSize eggCartonSize = EggCartonSize.MAPLE;

    @Override
    public void work() {
        this.getAnimals().forEach(animal -> {
            ArrayList<Egg> eggs = this.collectEggsFromAChicken((Chicken) animal, 2);
            this.addEggToCarton(eggs);
        });
    }

    public ArrayList<Egg> collectEggsFromAChicken(Chicken chicken, int quantity){
        return EggCreator.getEgg(chicken.getEggColor(), quantity);
    }

    public void addEggToCarton(ArrayList<Egg> eggs){
        eggs.forEach(egg ->{
            this.getLastNotFullCartonOfSameType(egg).addEgg(egg);
        });
    }

    public EggCarton getLastNotFullCartonOfSameType(Egg egg){
       for (EggCarton eggCarton: getProducts()){
           if (eggCarton.isNotFull() && eggCarton.isOfColor(egg)){
               return eggCarton;
           }
        }

       EggCarton eggCarton = EggCartonCreator.getEggCarton(eggCartonSize, egg.getEggColor());
       getProducts().add(eggCarton);
       return eggCarton;
    }

}
