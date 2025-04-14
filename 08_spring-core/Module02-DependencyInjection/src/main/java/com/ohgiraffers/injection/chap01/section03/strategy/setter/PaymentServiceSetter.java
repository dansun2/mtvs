package com.ohgiraffers.injection.chap01.section03.strategy.setter;

import com.ohgiraffers.injection.chap01.section03.service.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* 세터 주입 (Setter Injection)
* @Autowired를 Setter 메서드에 적용하여 의존성 주입.
장점:
선택적 의존성: 주입이 필수가 아님, 기본값 설정 가능.
런타임 변경 가능: 의존성을 동적으로 교체.
단점:
불변성 보장 불가: Setter로 언제든 변경 가능.
주입 누락 위험: Setter 호출 안 되면 null 상태로 사용 가능.
의존성 명확성 부족: 필수 의존성이 코드상으로 드러나지 않음.
예: 결제 게이트웨이를 실행 중에 변경하고 싶을 때 사용.
*/
@Service
public class PaymentServiceSetter { // 구현체가 없는 상태로 bean이 생성되거나 필드에 final 키워드가 없기 때문에 값이 바뀔 수 있음
    private PaymentInterface paymentGateway;

    @Autowired
    public void setPaymentGateway(PaymentInterface paymentGateway) {
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
