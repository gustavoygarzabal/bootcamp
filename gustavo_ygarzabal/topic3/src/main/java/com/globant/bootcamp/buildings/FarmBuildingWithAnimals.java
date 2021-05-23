package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Animal;
import com.globant.bootcamp.products.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class FarmBuildingWithAnimals<A extends Animal, T extends Product> extends RestrictedAnimalBox<A> implements Building<T>{
    private List<T> products = new ArrayList<>();

    @Override
    public List<T> getProducts() {
        return products;
    }

    public void setProducts(List<T> products) {
        this.products = products;
    }

    @Override
    public String showProducts() {
        String result ="";
        for (T product : products) {
            result = result.concat(product.toString());
        }
        return result;
    }

    @Override
    public void cleanProducts() {
        this.products.clear();
    }
}
