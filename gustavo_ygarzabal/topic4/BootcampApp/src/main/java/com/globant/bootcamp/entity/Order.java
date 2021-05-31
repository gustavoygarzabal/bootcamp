package com.globant.bootcamp.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.globant.bootcamp.model.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Double total;

    @Column(name = "date_order",nullable = false)
    @JsonFormat(pattern="yyy-MM-dd HH:mm:ss")
    private Timestamp orderDate;

    @Column(nullable = false)
    private OrderStatus orderStatus;

    @NotBlank(message = "A list of product is mandatory")
    @Column(nullable = false)
    private String productList;


    public Order () { };

    public Order(User user, Double total, OrderStatus orderStatus, String productList) {
        this.user = user;
        this.total = total;
        this.orderStatus = orderStatus;
        this.productList = productList;
    }

    @PrePersist
    public void prePersist(){
        orderDate=new Timestamp(new Date().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp dateOrder) {
        this.orderDate = dateOrder;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user+
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", productList='" + productList + '\'' +
                '}';
    }
}
