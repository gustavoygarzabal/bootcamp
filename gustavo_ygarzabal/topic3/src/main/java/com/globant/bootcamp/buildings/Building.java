package com.globant.bootcamp.buildings;

import com.globant.bootcamp.products.Product;

import java.util.List;

public interface Building {
    void work();
    String showProducts();
    void cleanProducts();
    List<Product> deliverProducts();


}
