package com.globant.bootcamp.buildings;

import com.globant.bootcamp.products.Product;

import java.util.ArrayList;

public interface Building {
    void work();
    String showProducts();
    void cleanProducts();
    ArrayList<Product> getProducts();
    void setProducts(ArrayList<Product> products);

}
