package com.ohgiraffers.injection.chap01.section01.service;

import org.springframework.stereotype.Component;

/*
* @Component
* - spring이 클래스를 컴포넌트로 인식하여 bean으로 등록하도록 지시한다.
* - 역할 : 일반적인 bean을 정의하며, spring 컨테이너가 관리할 객체임을 나타낸다.
* - bean 이름 : 기본값은 클래스명 첫 글자 소문자(kakaoPayGateway) -> 이름을 지정해주려면 @Component("bean이름")
* */
@Component
public class KakaoPayGateway implements PaymentInterface {

    @Override
    public boolean processPayment(String orderId, double amount) {
        System.out.println("카카오페이로 결제를 합니다. : " + orderId + " 가격 : " + amount);
        return true;
    }
}
