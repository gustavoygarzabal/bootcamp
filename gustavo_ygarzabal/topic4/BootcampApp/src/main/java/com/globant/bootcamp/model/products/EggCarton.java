package com.globant.bootcamp.model.products;


import com.globant.bootcamp.model.animals.Egg;
import com.globant.bootcamp.model.enums.EggColor;

import java.util.ArrayList;

public class EggCarton implements Product {
    private ArrayList<Egg> eggs;
    private EggColor eggColor;
    private int column;
    private int line;

    public EggCarton(EggColor eggColor) {
        this.setEggColor(eggColor);
    }

    public void addEgg(Egg egg) throws Exception{
        if(! eggColor.equals(egg.eggColor)){
            throw new Exception("You try to add a egg ith a different color");
        }
        if (!this.isFull()){
            this.getEggs().set(findIndexOfFreeSpace(), egg);
        }
    }

    public int getCapacity() {
        return line*column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setLine(int line) {
        this.line = line;
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

    public EggColor getEggColor() {
        return eggColor;
    }

    public boolean isOfColor(EggColor eggColor){
        return this.getEggColor().equals(eggColor);
    }

    public void setEggColor(EggColor eggColor) {
        this.eggColor = eggColor;
    }

    @Override
    public boolean isFull() {
        return !this.getEggs().contains(null);
    }

    @Override
    public boolean isNotFull() {
        return this.getEggs().contains(null);
    }

    @Override
    public String toString() {
        String result= String.format("\n==== %s ====\n", this.getEggColor());
        Egg currentEgg;
        String eggToString;

        for(int i=0; i<this.line; i++) {
            for(int j=0; j<this.column; j++){
                currentEgg = this.getEggs().get((i*this.column)+j);
                eggToString = currentEgg!=null? currentEgg.toString() : "(G)";
                result = result.concat(eggToString);
            }
            result = result.concat("\n");
        }
        result= result.concat("===============");
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EggCarton eggCarton = (EggCarton) o;
        return column == eggCarton.column && line == eggCarton.line && eggs.equals(eggCarton.eggs) && eggColor == eggCarton.eggColor;
    }

}
