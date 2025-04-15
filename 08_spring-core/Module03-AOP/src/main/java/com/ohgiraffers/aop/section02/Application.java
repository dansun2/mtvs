package com.ohgiraffers.aop.section02;

import com.ohgiraffers.aop.section02.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        System.out.println("====== AOP 적용 후 - 개선된 구조 ======");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = (MemberService) context.getBean("memberService");

        try {
            System.out.println("회원 등록 테스트");
            Member newMember = new Member("이름등록","aa123","aa@gmail.com","010-1111-1111","user");
            memberService.registerMember(newMember);
        } catch (Exception e) {
            System.out.println("예외 발생");
        }
    }
}
