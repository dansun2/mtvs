package com.ohgiraffers.chap01.section02.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "section02-customer")
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "", cascade = ) // 연관관계의 주인이 누군지를 알려줘야함. mappedBy는 이걸 어디서 관리하는거야? cascade 영속성전이
    private List<Order> orders = new ArrayList<>();

    protected Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                " 고객 번호 : " + customerId +
                ", 고객 이름 : '" + name + '\'' +
                '}';
    }
}
