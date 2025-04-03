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

    /*
    * 📌 양방향 연관관계 매핑
    * 고객은 여러 주문을 가질 수 있다 (1:N)
    * mappedBy: 연관관계의 주인이 되는 엔티티에서 정의한 필드의 이름을 명시한다.
    * 즉, Order의 customer(fk)를 지정함.
    *            = 연관관계 주인은 외래 키(FK)를 가지고 있으며, 해당 관계의 상태를 직접적으로 관리하는 것을 의미한다.
    *
    * 📌 Cascade 옵션
    * cascade = CascadeType.ALL:
    * ALL을 쓰면 아래의 모든 권한이 주어지기 때문에 잘 쓰진 않는다.
    * 고객 저장 시 관련된 "모든 주문도 함께 저장"된다.
    * 예를 들어, 고객을 저장하면 그 고객의 모든 주문도 자동으로 저장된다.
    *
    * 다른 CascadeType 옵션:
    * PERSIST: 고객 저장 시 주문도 저장
    * REMOVE: 고객 삭제 시 주문도 삭제
    * MERGE: 고객 병합 시 주문도 병합
    * REFRESH: 고객 새로 고침 시 주문도 새로 고침
    * NONE : 아무런 전파가 없는 것을 의미하며 (기본 값)
    */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // 연관관계의 주인이 누군지를 알려줘야함. mappedBy는 이걸 어디서 관리하는거야?(필드명) cascade 영속성전이
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

    public int getCustomerId() {
        return customerId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                " 고객 번호 : " + customerId +
                ", 고객 이름 : '" + name + '\'' +
                '}';
    }
}
