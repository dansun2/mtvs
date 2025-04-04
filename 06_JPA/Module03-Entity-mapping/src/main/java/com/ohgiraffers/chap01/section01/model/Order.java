package com.ohgiraffers.chap01.section01.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "section01-order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    /*
    * ManyToOne : 다대일 단방향 매핑 (주문 -> 고객)
    * - 주문은 반드시 고객 한 명에게 속한다.
    * - 연관관계의 주인이므로 @JoinColumn으로 외래키를 명시한다.
    *
    * - 지연 로딩(Lazy) : 실제로 사용할 때 조회하도록 설정해 놓은 성능 최적화
    *   (초기에는 프록시 객체로 대기하다가, getCustomer() 호출 시 DB에서 조회한다.)
    *   Lazy는 쿼리가 두 번 실행됨 
    *
    * - 즉시 로딩(Eager) : 연관된 엔티티를 즉시 조회하도록 설정한다.
    *   (주문을 조회할 때 관련된 고객 정보도 함께 조회된다.)
    *   Eager 는 Join시켜서 쿼리를 한 번 날림
    *
    * 선택에 따라 성능과 메모리 사용량에 영향을 줄 수 있으므로,
    * 상황에 맞게 적절한 전략을 선택해야 한다.
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id") // 상대편의 Id 어노테이션과 연관관계를 맺겠다
    private Customer customer; // customer 객체를 담고 있기 때문에 customerId는 좀 이상하다

    @Column(name = "order_date")
    private LocalDate orderDate = LocalDate.now();

    protected Order() {
    }

    public Order(Customer customer) {
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
