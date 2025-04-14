package com.ohgiraffers.injection.chap01.section03.strategy.field;

import com.ohgiraffers.injection.chap01.section03.service.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* 필드 주입 (Field Injection)
* @Autowired를 필드에 직접 적용하여 의존성 주입.
* 장점:
* 코드 간결: 생성자나 세터 메서드 없이 주입 가능.
* 빠른 구현: 프로토타입 개발 시 유용.
* 단점:
* 불변성 보장 불가: final 사용 불가, 런타임에 변경 가능.
* 테스트 어려움: 의존성을 외부에서 주입하기 어려움 (리플렉션 필요).
* 주입 시점 불명확: 객체 생성 후 언제 주입되는지 알기 어려움.
* 의존성 숨김: 필수 의존성이 코드상으로 드러나지 않음.
* 예: 빠른 개발이 필요한 경우 사용, 하지만 권장되지 않음.
*/
@Service
public class PaymentServiceField {

    @Autowired
    private PaymentInterface paymentGateway; // 불변성을 보장할 수 없음. 먼저 생성자 호출하고 값을 autowired로 주입

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
