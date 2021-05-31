package com.globant.bootcamp.rest.repository;

import com.globant.bootcamp.rest.entity.OrderLine;
import com.globant.bootcamp.rest.entity.OrderLinePk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, OrderLinePk> {
}
