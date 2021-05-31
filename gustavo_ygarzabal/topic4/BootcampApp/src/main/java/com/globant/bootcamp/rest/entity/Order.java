package com.globant.bootcamp.rest.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.globant.bootcamp.model.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank(message = "A deliver address is necessary")
    private String address;

//    @Column(nullable = false)
//    private Double total;

    @Column(name = "date_order",nullable = false)
    @JsonFormat(pattern="yyy-MM-dd HH:mm:ss")
    private Timestamp orderDate;

    @Column(nullable = false)
    private OrderStatus orderStatus;

//    @NotBlank(message = "A list of product is mandatory")
//    @Column(nullable = false)

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    private List<OrderLine> productList = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderLine> orderProducts = getProductList();
        for (OrderLine op : orderProducts) {
            sum += op.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts(){
        return this.productList.size();
    }


    public Order () { };
//Double total,
    public Order(User user, String address ,OrderStatus orderStatus) {
        this.user = user;
//        this.total = total;
        this.address = address;
        this.orderStatus = orderStatus;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //    public Double getTotal() {
//        return total;
//    }
//
//    public void setTotal(Double total) {
//        this.total = total;
//    }

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

    public List<OrderLine> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderLine> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user+
                ", total=" + getTotalOrderPrice() +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", productList='" + productList + '\'' +
                '}';
    }
}
