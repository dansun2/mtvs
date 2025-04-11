package com.ohgiraffers.chap01.section01.service;

/*
* 기존 java 개발 방식의 문제점
*   1. 강한 결합도 (필드에 직접적으로 매개변수 타입을 잡아줌, 생성자에서도 직접적으로 명시해줌)
*   2. 객체 생성의 책임 : PaymentService가 KakaoPay에서 -> NaverPay로 변경되어야 함
* */
public class PaymentService {

    private NaverPayGateway paymentGateway;

    public PaymentService() {
        this.paymentGateway = new NaverPayGateway();
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 처리를 시작합니다. 주문 ID : " + orderId + ", 금액 : " + amount);

        boolean result = paymentGateway.processPayment(orderId, amount);
        if (result) {
            System.out.println("결제가 성공적으로 처리되었습니다.");
        } else {
            System.out.println("결제 처리 중 오류가 발생하였습니다.");
        }
        return result;
    }
}
