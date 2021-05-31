package com.globant.bootcamp.service;

import com.globant.bootcamp.entity.OrderLine;
import com.globant.bootcamp.repository.OrderLineRepository;
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
