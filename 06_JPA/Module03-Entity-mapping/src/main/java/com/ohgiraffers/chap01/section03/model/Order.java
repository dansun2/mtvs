package com.ohgiraffers.chap01.section03.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "section03-order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "customer_id")
    private int customerId;


    /*
    * 1:1 양방향 연관관계 매핑
    * - 주문(order)은 하나의 배송(delivery)를 가질 수 있고, 배송은 하나의 주문에 속한다(1:1)
    * - mappedBy : 연관관계의 주인이 되는 엔티티에서 정의한 필드의 이름을 명시한다.
    *   즉, Delivery의 Order(fk)를 지정한다.
    * - 연관관계 주인은 외래키(fk)를 가지고 있으며, 해당 관계의 상태를 직접적으로 관리하는 것을 의미한다.
    * */
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery;

    @Column(name = "order_date")
    private LocalDate date = LocalDate.now();

    protected Order() {
    }

    public Order(int customerId) {
        this.customerId = customerId;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", delivery=" + delivery +
                ", date=" + date +
                '}';
    }
}
