package com.ohgiraffers.injection.chap01.section03;

import com.ohgiraffers.injection.chap01.section03.config.AppConfig;
import com.ohgiraffers.injection.chap01.section03.strategy.setter.PaymentServiceSetter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* 의존성 주입 (Dependency Injection, DI)
* - Spring 프레임워크에서 객체 간 의존성을 개발자가 직접 관리하지 않고, IoC 컨테이너가 자동으로 주입하는 메커니즘.
* - 동작 방식:
*   1. 컴포넌트 스캔(@ComponentScan)으로 Bean 등록: @Component, @Service 등이 붙은 클래스를 탐지.
*   2. 의존성 탐색: @Autowired 또는 생성자 주입으로 필요한 Bean을 찾아 연결.
*   3. 주입 완료: PaymentService에 PaymentInterface 구현체가 자동으로 주입됨.
*
* - 이점:
*   1. 결합도 감소: 객체가 의존성을 직접 생성하지 않으므로 코드 유연성 증가.
*     - 예: PaymentService가 KakaoPayGateway를 직접 new 하지 않고 주입받음.
*   2. 테스트 용이성: Mock 객체로 쉽게 대체 가능.
*     - 예: 단위 테스트에서 가짜 결제 게이트웨이를 주입.
*   3. 유지보수성 향상: 의존성 변경 시 코드 수정 최소화.
*     - 예: NaverPayGateway에서 KakaoPayGateway로 변경해도 PaymentService 수정 불필요.
*
* - 주의: 동일 타입의 Bean 충돌 가능성
*   - 현재 PaymentInterface를 구현한 KakaoPayGateway와 NaverPayGateway가 모두 @Component로 등록된 경우:
*     - Spring이 PaymentService에 주입할 Bean을 결정하지 못해 NoUniqueBeanDefinitionException 발생.
*     - 예: PaymentService 생성 시 "어떤 PaymentInterface를 주입해야 할지" 모호함.
*   - 해결 방법:
*     - 1. @Qualifier: 특정 Bean을 이름으로 지정 (예: @Qualifier("naverPayGateway")).
*     - 2. @Primary: 기본으로 사용할 Bean 지정.
*     - 3. 단일 구현체 사용: 불필요한 구현체의 @Component 제거.
* - 결론: 의존성 주입은 Spring의 핵심 기능으로, 컴포넌트 스캔과 함께 사용 시 더욱 강력해짐.
*/
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        PaymentServiceSetter paymentServiceSetter = new PaymentServiceSetter(); 이래도 컴파일시점에는 문제가 없음 (런타임에서 오류)
        PaymentServiceSetter paymentServiceSetter = context.getBean(PaymentServiceSetter.class);
        paymentServiceSetter.processPayment("sef",100.0);

        System.out.println("=== 의존성 주입 테스트 ===");
        /*

필드 주입 (Field Injection)
PaymentServiceField에서 @Autowired를 필드에 직접 적용.
특징: 의존성이 필드에 바로 주입되어 생성자나 세터 없이 동작.
사용 시나리오: 빠른 프로토타입 개발, 간단한 설정에서 유용.
주의: 불변성 보장 불가, 테스트 시 Mock 주입 어려움.
예: KakaoPayGateway가 paymentGatewayField에 주입됨.
*/
        PaymentServiceField fieldService = context.getBean(PaymentServiceField.class);
        fieldService.processPayment("field 100", 100.0);
        System.out.println();

        /*

생성자 주입 (Constructor Injection)
PaymentServiceConstructor에서 @Autowired를 생성자에 적용.
특징: 의존성이 생성 시점에 주입되며, final로 불변성 보장.
사용 시나리오: 필수 의존성이 명확한 경우, Spring 권장 방식.
주의: 의존성 많으면 생성자 길어질 수 있음.
예: KakaoPayGateway가 paymentGatewayConstructor에 주입됨.
*/
        PaymentServiceConstructor constructorService = context.getBean(PaymentServiceConstructor.class);
        constructorService.processPayment("constructor 200", 200.0);

        System.out.println();


        /*

세터 주입 (Setter Injection)
PaymentServiceSetter에서 @Autowired를 Setter 메서드에 적용.
특징: 의존성이 Setter를 통해 주입, 런타임에 변경 가능.
사용 시나리오: 선택적 의존성, 동적 의존성 변경이 필요한 경우.
주의: 주입 누락 시 null 위험, 불변성 보장 불가.
예: KakaoPayGateway가 setPaymentGateway()로 paymentGatewaySetter에 주입됨.
*/
        PaymentServiceSetter setterService = context.getBean(PaymentServiceSetter.class);
        setterService.processPayment("setter 300", 300.0);

        ((AnnotationConfigApplicationContext) context).close();
    }
}
