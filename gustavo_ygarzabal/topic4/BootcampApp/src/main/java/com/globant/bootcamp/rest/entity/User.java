package com.globant.bootcamp.rest.entity;

import com.globant.bootcamp.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Address is mandatory")
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "role", nullable = false)
    private Role role;

    @NotBlank(message = "Password is mandatory")
    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    public User() {};

    public User(String name, String email, String address, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    @PrePersist
    public void prePersist(){
        this.role = Role.USER;
    }

    public void addOrder(Order order) {
        if(orderList == null) orderList = new ArrayList<>();
        orderList.add(order);
        order.setUser(this);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                    Objects.equals(name, user.name) &&
                    Objects.equals(email, user.email) &&
                    Objects.equals(address, user.address) &&
                    Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, address, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
