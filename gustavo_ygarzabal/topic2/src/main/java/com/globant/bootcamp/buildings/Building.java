package com.globant.bootcamp.buildings;

import com.globant.bootcamp.productFactory.Product;

import java.util.ArrayList;

public interface Building {
    void work();
    void showProducts();
    void cleanProducts();
    ArrayList<Product> getProducts();
    void setProducts(ArrayList<Product> products);

}
