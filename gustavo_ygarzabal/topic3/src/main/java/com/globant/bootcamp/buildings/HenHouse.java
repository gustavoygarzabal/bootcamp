package com.globant.bootcamp.buildings;

import com.globant.bootcamp.enums.EggCartonSize;
import com.globant.bootcamp.productFactory.EggCartonCreator;
import com.globant.bootcamp.productFactory.EggCreator;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.products.EggCarton;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HenHouse extends FarmBuildingWithAnimals<Chicken, EggCarton> {
    static final Logger logger = Logger.getLogger(HenHouse.class.getName());
    private EggCartonSize eggCartonSize = EggCartonSize.MAPLE;

    @Override
    public void work() {
        this.getAnimals().forEach(animal -> {
            ArrayList<Egg> eggs = this.collectEggsFromAChicken(animal, 2);
            this.addEggToCarton(eggs);
        });
    }

    public ArrayList<Egg> collectEggsFromAChicken(Chicken chicken, int quantity){
        return EggCreator.getEgg(chicken.getEggColor(), quantity);
    }

    public void addEggToCarton(List<Egg> eggs){
        eggs.forEach(egg -> {
            try {
                this.getLastNotFullCartonOfSameType(egg).addEgg(egg);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        });
    }

    public EggCarton getLastNotFullCartonOfSameType(Egg egg){
       for (EggCarton eggCarton: getProducts()){
           if (eggCarton.isNotFull() && eggCarton.isOfColor(egg.getEggColor())){
               return eggCarton;
           }
        }

       EggCarton eggCarton = EggCartonCreator.getEggCarton(eggCartonSize, egg.getEggColor());
       getProducts().add(eggCarton);
       return eggCarton;
    }

    public void setEggCartonSize(EggCartonSize eggCartonSize) {
        this.eggCartonSize = eggCartonSize;
    }
}
