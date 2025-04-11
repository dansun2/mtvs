package com.ohgiraffers.chap01.section04.service;

public class NaverPayGateway implements PaymentInterface {

    @Override // 생략해도 상관없지만 일반적으로 명시해주는게 더 좋다
    public boolean processPayment(String orderId, double amount) {
        System.out.println("네이버페이로 결제를 진행합니다. 주문 번호 : " + orderId + ", 금액 : " + amount);
        return true;
    }
}
