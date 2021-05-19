package com.globant.bootcamp.buildings;

import com.globant.bootcamp.products.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimalBuilding extends RestrictedAnimalBox implements Building{
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return products;
    }

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
