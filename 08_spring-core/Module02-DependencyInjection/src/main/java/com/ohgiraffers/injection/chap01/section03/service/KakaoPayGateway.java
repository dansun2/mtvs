package com.ohgiraffers.injection.chap01.section03.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class KakaoPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오페이로 결제를 합니다. 주문ID : " + orderId + ", 가격 : " + amount);
        return true;
    }
}
