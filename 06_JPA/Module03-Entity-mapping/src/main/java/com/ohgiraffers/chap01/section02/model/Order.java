package com.ohgiraffers.chap01.section02.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "section02-order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id") // 상대편의 Id 어노테이션과 연관관계를 맺겠다
    private Customer customer; // customer 객체를 담고 있기 때문에 customerId는 좀 이상하다

    @Column(name = "order_date")
    private LocalDate orderDate = LocalDate.now();

    public Order() {
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                '}';
    }
}
