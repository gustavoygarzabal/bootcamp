package com.globant.bootcamp.buildings;

import com.globant.bootcamp.products.Product;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AnimalBuilding extends AnimalManager implements Building{
    private  ArrayList<Product> products = new ArrayList<>();

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    //TODO not implemented yet
    @Override
    public String showProducts() {
        String result ="";
        for (Product product : products) {
            result = result.concat(product.toString());
        }
        return result;
    }

    @Override
    public void cleanProducts() {
        this.products.clear();
    }
}
