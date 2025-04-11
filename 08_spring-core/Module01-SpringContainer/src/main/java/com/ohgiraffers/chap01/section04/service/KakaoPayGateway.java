package com.ohgiraffers.chap01.section04.service;

/**
 * 카카오페이 결제 게이트웨이 구현체
 * 실제 결제 처리를 담당하는 클래스
 * */
public class KakaoPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오페이로 결제를 진행합니다. 주문 번호 : " + orderId + ", 금액 : " + amount);
        return true;
    }
}
