package com.globant.bootcamp.rest.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Objects;

@Entity
public class OrderLine {

    @EmbeddedId
    @JsonIgnore
    private OrderLinePk pk;

    @Column(nullable = false)
    private Integer quantity;

    public OrderLine() {}

    public OrderLine(Order order, Product product, Integer quantity) {
        this.pk = new OrderLinePk(order, product);
        this.quantity = quantity;
    }

    @Transient
    public Product getProduct(){
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }


    public OrderLinePk getPk() {
        return pk;
    }

    public void setPk(OrderLinePk pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(pk, orderLine.pk) && Objects.equals(quantity, orderLine.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, quantity);
    }
}
