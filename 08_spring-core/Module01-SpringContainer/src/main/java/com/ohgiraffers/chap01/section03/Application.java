package com.ohgiraffers.chap01.section03;

import com.ohgiraffers.chap01.section03.config.Appconfig;
import com.ohgiraffers.chap01.section03.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // IOC ??? 공부해보기 IOC는 DI를 보조하기 위해 필요
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        String orderId = "order-123";
        double amount = 100.0;

        //싱글톤 스코프 테스트
        System.out.println("=================싱글톤 스코프 테스트 =================");

        PaymentService singlePay = context.getBean("singlePay",PaymentService.class);
        boolean result = singlePay.processPayment(orderId, amount);
        System.out.println(singlePay.getLastOrderId());

        PaymentService singlePay2 = context.getBean("singlePay",PaymentService.class);
        System.out.println(singlePay2.getLastOrderId());

        System.out.println(singlePay == singlePay2);


        // 프로토타입 스코프 테스트
        System.out.println("==== 프로토타입 스코트 ㅌ스트");
        PaymentService protoPay = context.getBean("protoPay", PaymentService.class);
        protoPay.processPayment(orderId, amount);
        System.out.println("마지막 주문 ; "+ protoPay.getLastOrderId());

        PaymentService protoPay2 = context.getBean("protoPay", PaymentService.class);
        System.out.println("마지막 주문 ; "+ protoPay.getLastOrderId());

        System.out.println(protoPay == protoPay2);
    }
}
