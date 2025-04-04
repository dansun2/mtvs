package com.ohgiraffers.chap01.section03.model;

import jakarta.persistence.*;

@Entity(name = "section03-delivery")
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    /*
    * 연관관계의 주인 :
    * - Delivery가 외래키를 가지므로 주인이다.
    * - @OneToOne   : 일대일 단방향 매핑
    * - @JoinColumn : 외래키가 위치한 컬럼 이름 설정
    * */
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "status", nullable = false)
    private String status;

    public Delivery() {
    }

    public Delivery(String address, Order order) {
        this.address = address;
        this.order = order;
        this.status = "NEW";
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                // 여기 order가 들어있으면 Order 클래스에서도 Delivery를 참조하고 Delivery 클래스에서도 Order를 참조해서 스택오버플로우가 일어남
                ", status='" + status + '\'' +
                '}';
    }
}
