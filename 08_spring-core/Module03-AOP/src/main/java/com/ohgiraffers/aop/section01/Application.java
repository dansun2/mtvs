package com.ohgiraffers.aop.section01;

public class Application {
    public static void main(String[] args) {
        System.out.println("AOP를 적용하지 않았을 떄 문제 확인");

        MemberService memberService = new MemberService();

        try {
            System.out.println("회원가입 테스트 하기");
            Member member = new Member("이름뭐야", "a123123as","user@gmail.com","010-1111-1111","user");
            memberService.registerMember(member);

            System.out.println("회원조회 테스트");
            Member findMember = memberService.getMember("user@gmail.com");
            System.out.println(findMember);
        } catch (Exception e) {
            System.out.println("오류가 발생됨");
        }
    }


}
