package com.globant.bootcamp.buildings;

import com.globant.bootcamp.productFactory.Product;

import java.util.ArrayList;

public abstract class AnimalBuilding extends AnimalManager implements Building{
    private ArrayList<Product> products = new ArrayList<>();

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
    public void showProducts() {
        products.forEach(Product::printProduct);
    }

    @Override
    public void cleanProducts() {
        this.products.clear();
    }
}
