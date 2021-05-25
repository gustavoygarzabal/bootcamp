package com.globant.bootcamp.model.buildings;

import java.util.List;

public interface Building<T>{
    void work();
    String showProducts();
    void cleanProducts();
    List<T> getProducts();


}
