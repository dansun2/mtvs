package com.ohgiraffers.chap01.section02;
/*
* 양방향 연관관계 매핑(1:N <-> N:1) -> N:N이 아님!!
* - 고객은 여러 주문을 가질 수 있고, 각 주문은 하나의 고객에게 귀속된다.
* - 이 경우, Order 클래스에서 Customer를 참조하고 Customer 클래스에서 Order 목록을 참조하여 양방향 관계를 형성한다.
* */
public class Application {
    public static void main(String[] args) {

    }
}
