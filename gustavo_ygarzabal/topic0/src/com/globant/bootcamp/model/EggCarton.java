package com.globant.bootcamp.model;

import com.globant.bootcamp.animals.Egg;

import java.util.ArrayList;

public class EggCarton extends Product{
    private ArrayList<Egg> eggs;
    private String eggColor;
    private final int column = 5;
    private final int line = 6;


    public EggCarton(int capacity) {
        super(capacity);
        ArrayList<Egg> carton = new ArrayList<Egg>();
        for(int i=0; i<capacity; i++){
            carton.add(null);
        }
        this.setEggs(carton);
    }

    public EggCarton(int capacity, String eggColor) {
        this(capacity);
        this.setEggColor(eggColor);
    }

    //TODO Agregar esto
    public boolean addEgg(Egg egg){
        if (!this.isFull()){
            this.getEggs().set(findIndexOfFreeSpace(), egg);
            return true;
        }
        return false;
    }

    public int findIndexOfFreeSpace(){
        return this.getEggs().indexOf(null);
    }

    public ArrayList<Egg> getEggs() {
        return eggs;
    }

    public void setEggs(ArrayList<Egg> eggs) {
        this.eggs = eggs;
    }

    public String getEggColor() {
        return eggColor;
    }

    public void setEggColor(String eggColor) {
        this.eggColor = eggColor;
    }

    @Override
    public boolean isFull() {
        return !this.getEggs().contains(null);
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    public void printProductDescription() {
        int count = 0;
        int countColor = 0;
        for(int i=0; i < this.getEggs().size(); i++){
            if(this.getEggs().get(i)!= null){
                count++;
                if(this.getEggs().get(i).getEggColor().equals(this.getEggColor())){
                    countColor++;
                }
            }
        }

        System.out.println("This is a Egg Carton with a capacity of : " + this.getEggs().size());
        System.out.println("This is a Egg Carton of color: " + this.eggColor);
        System.out.println(("This Egg Carton have "+count+" eggs"));
        System.out.println(("This Egg Carton have "+countColor+" "+ this.eggColor+" eggs"));
        System.out.println(("----------------------------------"));
    }

    @Override
    public void printProduct() {
        for(int i=0; i<this.line; i++) {
            for(int j=0; j<this.column; j++){
                Egg currentEgg = this.getEggs().get((i*this.column)+j);
                if(currentEgg!=null){
                    System.out.print(currentEgg.toString());
                } else {
                    System.out.print("(G)");
                }
            }
            System.out.println();
        }
        System.out.println("===========");
    }



}
