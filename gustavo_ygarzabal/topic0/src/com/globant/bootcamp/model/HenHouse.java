package com.globant.bootcamp.model;

import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.animals.Chicken;
import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.Gender;

import java.util.ArrayList;

public class HenHouse extends Building{
    private ArrayList<Product> eggCartons = new ArrayList<Product>();

    public HenHouse(int capacity) {
        super(capacity);
        this.addAllowedAnimal(new Chicken(Gender.FEMALE));
    }

    public ArrayList<Product> getEggCartons() {
        return eggCartons;
    }

    public void setEggCartons(ArrayList<Product> eggCartons) {
        this.eggCartons = eggCartons;
    }

    //TODO implements this method
    @Override
    public ArrayList<Product> work() {
        this.getAnimals().forEach(animal -> {
            ArrayList<Egg> eggs = this.collectEggsFromAChicken((Chicken) animal);
            this.addEggToCarton(eggs);
        });
        return this.getEggCartons();
    }

    public ArrayList<Egg> collectEggsFromAChicken(Chicken chicken){
        return chicken.getEggs();
    }

    public void addEggToCarton(ArrayList<Egg> eggs){
        eggs.forEach(egg ->{
            int index = this.getIndexOfLastNotFullCartonOfType(egg);
            ((EggCarton)this.getEggCartons().get(index)).addEgg(egg);
        });
    }

    public int getIndexOfLastNotFullCartonOfType(Egg egg){
        String eggColor = egg.getEggColor();
        ArrayList<Product> cartons = this.getEggCartons();
        int cartonIndex = 0;
        while(cartonIndex< cartons.size()){
            if (!cartons.get(cartonIndex).isFull()){
                if(((EggCarton)cartons.get(cartonIndex)).getEggColor().equals(eggColor)){
                    return cartonIndex;
                }
            }
            cartonIndex++;
        }
        this.getEggCartons().add(new EggCarton(30, eggColor));
        return cartonIndex;
    }

    public int getIndexOfLastNotFullCartonOfType2(Egg egg){
        String eggColor = egg.getEggColor();
        ArrayList<Product> cartons = this.getEggCartons();
        int cartonIndex = 0;
        while(cartonIndex< cartons.size()){
            if (!cartons.get(cartonIndex).isFull()){
                if(((EggCarton)cartons.get(cartonIndex)).getEggColor().equals(eggColor)){
                    return cartonIndex;
                }
            }
            cartonIndex++;
        }
        this.getEggCartons().add(new EggCarton(30));
        return cartonIndex;
    }



}
