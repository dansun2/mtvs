package com.ohgiraffers.chap01.section04.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "section04-customer")
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    // orphanRemoval는 엔티티가 연관관계가 끊어졌을때 이걸 영속성 컨텍스트에서 지우겠다
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    protected Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
