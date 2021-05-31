package com.globant.bootcamp.controller.rest;

import com.globant.bootcamp.controller.rest.assembler.OrderModelAssembler;
import com.globant.bootcamp.controller.rest.exception.OrderNotFoundException;
import com.globant.bootcamp.controller.rest.exception.UserNotFoundException;
import com.globant.bootcamp.entity.Order;
import com.globant.bootcamp.model.enums.OrderStatus;
import com.globant.bootcamp.repository.OrderRepository;
import com.globant.bootcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository,
                           OrderModelAssembler orderModelAssembler) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderModelAssembler = orderModelAssembler;
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
        if(!userRepository.existsById(id)) throw new UserNotFoundException(id);

        newOrder.setOrderStatus(OrderStatus.IN_PROGRESS);
        newOrder.setUser(userRepository.getById(id));
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



}
