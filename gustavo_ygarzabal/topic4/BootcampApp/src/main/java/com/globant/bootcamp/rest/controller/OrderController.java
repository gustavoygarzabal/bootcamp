package com.globant.bootcamp.rest.controller;

import com.globant.bootcamp.rest.assembler.OrderModelAssembler;
import com.globant.bootcamp.rest.exception.OrderNotFoundException;
import com.globant.bootcamp.rest.exception.UserNotFoundException;
import com.globant.bootcamp.rest.entity.Order;
import com.globant.bootcamp.rest.entity.OrderLine;
import com.globant.bootcamp.model.enums.OrderStatus;
import com.globant.bootcamp.rest.repository.OrderRepository;
import com.globant.bootcamp.rest.repository.UserRepository;
import com.globant.bootcamp.rest.service.OrderLineService;
import com.globant.bootcamp.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderModelAssembler orderModelAssembler;
    private final OrderLineService orderLineService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository,
                           OrderModelAssembler orderModelAssembler, OrderLineService orderLineService,
                           ProductService productService) {
        this.productService = productService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderModelAssembler = orderModelAssembler;
        this.orderLineService = orderLineService;
    }


    @GetMapping("")
    public CollectionModel<EntityModel<Order>> all() {
        List<EntityModel<Order>> orders = orderRepository.findAll().stream()
                .map(orderModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(orders,
                linkTo(methodOn(OrderController.class).all()).withSelfRel());
    }

    @GetMapping("/id={id}")
    public EntityModel<Order> getOrderById(@PathVariable Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        return orderModelAssembler.toModel(order);
    }

    @PostMapping("/id={id}")
    public ResponseEntity<?> addOrder(@Valid @RequestBody Order newOrder , @PathVariable Long id){

        newOrder.setOrderStatus(OrderStatus.IN_PROGRESS);
        newOrder.setUser(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
        Order order = orderRepository.save(newOrder);

        return ResponseEntity.created(linkTo(methodOn(OrderController.class).getOrderById(order.getId())).toUri())
                .body(orderModelAssembler.toModel(order));
    }

    @DeleteMapping("/id={id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        if (order.getOrderStatus() == OrderStatus.IN_PROGRESS) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            return ResponseEntity.ok(orderModelAssembler.toModel(orderRepository.save(order)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create()
                        .withTitle("Method not allowed")
                        .withDetail("You can't cancel an order that is in the " + order.getOrderStatus() + " status"));
    }

    @PutMapping("/id={id}/complete")
    public ResponseEntity<?> complete(@PathVariable Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        if (order.getOrderStatus() == OrderStatus.IN_PROGRESS) {
            order.setOrderStatus(OrderStatus.COMPLETED);
            return ResponseEntity.ok(orderModelAssembler.toModel(orderRepository.save(order)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create()
                        .withTitle("Method not allowed")
                        .withDetail("You can't complete an order that is in the " + order.getOrderStatus() + " status"));
    }

    //TODO check if the product exist
    @PostMapping("/id={id}/addProduct={idProduct}/quantity={quantity}")
    public ResponseEntity<?> addProduct(@PathVariable Long id, @PathVariable Long idProduct, @PathVariable int quantity) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        OrderLine newOrderLine = new OrderLine(
                order,
                productService.getProduct(idProduct),
                quantity
        );

        orderLineService.save(newOrderLine);
        return ResponseEntity.created(orderModelAssembler.toModel(order).getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(order);

    }



}
