package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Product;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.products.EggCarton;

import java.util.ArrayList;

public class HenHouse extends AnimalBuilding {

    @Override
    public void work() {
        this.getAnimals().forEach(animal -> {
            ArrayList<Egg> eggs = this.collectEggsFromAChicken((Chicken) animal);
            this.addEggToCarton(eggs);
        });
    }

    public ArrayList<Egg> collectEggsFromAChicken(Chicken chicken){
        return chicken.getLaidEggs();
    }

    public void addEggToCarton(ArrayList<Egg> eggs){
        eggs.forEach(egg ->{
            int index = this.getIndexOfLastNotFullCartonOfType(egg);
            ((EggCarton)this.getProducts().get(index)).addEgg(egg);
        });
    }

    public int getIndexOfLastNotFullCartonOfType(Egg egg){
        ArrayList<Product> eggCartons = this.getProducts();
        int cartonIndex = 0;
        EggCarton carton;
        while(cartonIndex< eggCartons.size()){
            carton = (EggCarton) eggCartons.get(cartonIndex);
            if(!carton.isFull() && carton.isOfColor(egg)){
                return cartonIndex;
            }
            cartonIndex++;
        }
        eggCartons.add(new EggCarton(30,egg.getEggColor()));
        return cartonIndex;
    }



}
