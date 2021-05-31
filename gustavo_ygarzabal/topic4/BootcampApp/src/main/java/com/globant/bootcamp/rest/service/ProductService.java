package com.globant.bootcamp.rest.service;

import com.globant.bootcamp.rest.exception.ProductNotFoundException;
import com.globant.bootcamp.rest.entity.Product;
import com.globant.bootcamp.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;


    @Autowired
    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }

    public Product getProduct(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product save(Product product){
        return repository.save(product);
    }


}
