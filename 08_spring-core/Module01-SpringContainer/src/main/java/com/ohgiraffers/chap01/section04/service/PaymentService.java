package com.ohgiraffers.chap01.section04.service;

public class PaymentService {

    private PaymentInterface paymentGateway;

    public PaymentService(PaymentInterface paymentGateway) {
        this.paymentGateway = paymentGateway;
        System.out.println("1. Bean 생성: PaymentService 인스턴스가 생성되었습니다.");
    }

    /*
    * 초기화 메서드
    * - bean 생성 및 의존성 주입 후 호출됨
    * - 주로 리소스 초기화, 설정 로드, 준비 작업을 수행
    * - 예시
    *   - 데이터베이스 연결 설정
    *   - 캐시 초기화
    *   - api 인증 토큰 발급과 같은 작업
    *
    * - 무거운 작업의 경우 별도의 프로세스를 분리하여 사용하는것이 좋다.
    * */
    public void init() {
        System.out.println("2. Bean 초기화 : paymentService가 초기화 되었습니다.");
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

    /*
    * 소멸 메서드
    * 컨테이너 종료 시 bean 소멸 직전에 호출됨
    * 리소스를 해제하거나 정리 작업을 수행하는데 사용된다
    * */
    public void destroy() {
        System.out.println("4. Bean 소멸 : PaymentService가 소멸되었습니다.");
    }
}
