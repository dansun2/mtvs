package com.ohgiraffers.injection.chap01.section01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// IOC 기술에 대해 찾아보기. 프레임워크가 빈 관리? + @Autowired(매개변수 타입에 맞는걸 찾고 주입?) 의존성관리(DI)
/*
* PaymentService 클래스
* - @Service
*   - @Component의 특수화된 형태로, 서비스 계층(Service Layer)에 속하는 bean을 나타낸다.
*   - 역할 : 비즈니스 로직을 처리하는 클래스에 사용하며, spring이 이를 bean으로 등록한다. -> @Component라고 써도 애플리케이션은 돌아가지만 @Service라고 쓰면 개발자들끼리 구분이 명확하다
*   - bean 이름 : paymentService
* */
@Service
public class PaymentService {
    private final KakaoPayGateway paymentGateway;

    @Autowired // 우리가 의존성을 직접 주입하지 않아도 자동으로 주입되는 DI기술
    public PaymentService(KakaoPayGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean processPayment(String orderId, double amount) {
        System.out.println("결제 처리를 시작합니다. 주문ID : " + orderId + ", 금액 : " + amount);
        boolean result = paymentGateway.processPayment(orderId, amount);

        if (result) {
            System.out.println("결제가 성공되었습니다.");
        } else {
            System.out.println("결제가 실패되었습니다.");
        }
        return result;
    }
}
