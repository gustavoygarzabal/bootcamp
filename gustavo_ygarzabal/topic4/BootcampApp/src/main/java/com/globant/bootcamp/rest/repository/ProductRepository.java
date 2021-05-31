package com.globant.bootcamp.rest.repository;

import com.globant.bootcamp.rest.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
