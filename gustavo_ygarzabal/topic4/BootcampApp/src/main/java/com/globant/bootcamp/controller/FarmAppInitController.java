package com.globant.bootcamp.controller;

import com.globant.bootcamp.BootcampAppApplication;
import com.globant.bootcamp.model.buildings.Farm;
import com.globant.bootcamp.model.buildings.FarmCreator;
import com.globant.bootcamp.model.buildings.HenHouseCreator;
import com.globant.bootcamp.model.products.Product;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FarmAppInitController {
    static final Logger logger = Logger.getLogger(BootcampAppApplication.class.getName());

    public FarmAppInitController() {
        Farm farm = new FarmCreator().createBuilding(5);
        System.out.println(farm.getCapacity());
        farm.addBuilding(new HenHouseCreator().createBuilding((int)(40*0.7),(int)(40*0.3)));

    }

    @GetMapping("/")
    public List<Product> showEggs() {
        Farm farm = Farm.getInstance();
        logger.debug("Getting the farm instance");

        farm.work();
        logger.info(farm.showProducts());
        List<Product> products =  new ArrayList<>(farm.getProducts());
        farm.cleanProducts();
        return products;

    }
}
