package com.globant.bootcamp.rest.service;

import com.globant.bootcamp.rest.entity.OrderLine;
import com.globant.bootcamp.rest.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {
    private final OrderLineRepository repository;

    @Autowired
    public OrderLineService(OrderLineRepository repository) {
        this.repository = repository;
    }

    public OrderLine save(OrderLine orderLine){
        return repository.save(orderLine);
    }

}
