package com.ohgiraffers.chap01.section02.service;

public class PaymentService {

    private PaymentInterface paymentGateway;

    public PaymentService(PaymentInterface paymentGateway) {
        this.paymentGateway = paymentGateway;
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
