package com.globant.bootcamp.buildings;

import com.globant.bootcamp.abstracts.Product;

import java.util.ArrayList;
import java.util.Collection;

public interface Building {
    void work();
    void showProducts();
    void cleanProducts();
    ArrayList<Product> getProducts();
    void setProducts(ArrayList<Product> products);

}
