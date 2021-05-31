package com.globant.bootcamp.rest.controller;

import com.globant.bootcamp.rest.assembler.ProductModelAssembler;
import com.globant.bootcamp.rest.entity.Product;
import com.globant.bootcamp.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    private final ProductModelAssembler assembler;

    @Autowired
    public ProductController(ProductService service, ProductModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("")
    public CollectionModel<EntityModel<Product>> all() {
        List<EntityModel<Product>> products = service.getAllProducts()
            .stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(products,
                linkTo(methodOn(ProductController.class).all()).withSelfRel());
    }

    @GetMapping("id={id}")
    public EntityModel<Product> getProductById(@PathVariable Long id) {
         return assembler.toModel(service.getProduct(id));
    }


    //TODO add some validation
    @PostMapping("")
    public ResponseEntity<?> newProduct(@Valid @RequestBody Product product) {
        EntityModel<Product> entityModel = assembler.toModel(service.save(product));

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    //TODO add some other method put, delete
}
