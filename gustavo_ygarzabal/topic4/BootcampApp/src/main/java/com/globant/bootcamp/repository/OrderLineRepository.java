package com.globant.bootcamp.repository;

import com.globant.bootcamp.entity.OrderLine;
import com.globant.bootcamp.entity.OrderLinePk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, OrderLinePk> {
}
