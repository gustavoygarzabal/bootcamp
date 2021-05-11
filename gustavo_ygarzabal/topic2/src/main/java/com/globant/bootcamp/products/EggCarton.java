package com.globant.bootcamp.products;

import com.globant.bootcamp.abstracts.Product;
import com.globant.bootcamp.animals.Egg;
import com.globant.bootcamp.enums.EggColor;

import java.util.ArrayList;

public class EggCarton extends Product {
    private ArrayList<Egg> eggs;
    private EggColor eggColor;
    private int column=5;
    private int line=6;

    public EggCarton(int capacity) {
        super(capacity);
        ArrayList<Egg> carton = new ArrayList<Egg>();
        for(int i=0; i<capacity; i++){
            carton.add(null);
        }
        this.setEggs(carton);
    }

    public EggCarton(int capacity, EggColor eggColor) {
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

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getLine() {
        return line;
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

    public boolean isOfColor(Egg egg){
        return this.getEggColor().equals(egg.getEggColor());
    }

    public void setEggColor(EggColor eggColor) {
        this.eggColor = eggColor;
    }

    @Override
    public boolean isFull() {
        return !this.getEggs().contains(null);
    }

    @Override
    public int getCapacity() {
        return line*column;
    }

    @Override
    public void printProduct() {
        Egg currentEgg;
        for(int i=0; i<this.line; i++) {
            for(int j=0; j<this.column; j++){
                currentEgg = this.getEggs().get((i*this.column)+j);
                System.out.print((currentEgg!=null)? currentEgg.toString() : "(G)");
            }
            System.out.println();
        }
        System.out.println("===========");
    }

}
