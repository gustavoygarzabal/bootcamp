package com.globant.bootcamp.controller.rest.assembler;

import com.globant.bootcamp.controller.rest.ProductController;
import com.globant.bootcamp.controller.rest.UserController;
import com.globant.bootcamp.entity.Product;
import com.globant.bootcamp.entity.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler  implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product){
        return EntityModel.of(product,
                WebMvcLinkBuilder.linkTo(methodOn(ProductController.class).getProductById(product.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).all()).withRel("users")
        );

    }
}