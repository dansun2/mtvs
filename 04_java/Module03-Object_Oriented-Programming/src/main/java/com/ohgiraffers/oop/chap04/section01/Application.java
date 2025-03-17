package com.ohgiraffers.oop.chap04.section01;
/*
* 추상화란?
* - 복잡한 세부 사항을 숨기고, 중요한 기능만 드러내는 방법을 의미한다.
* - "abstract" 클래스나 인터페이스로 구현된다.
* - 비유 : 차 운전 시 엔진 구조를 몰라도 "가속" 버튼만 누르면 된다.
*
* 장점 :
* - 코드 단순화 : 불필요한 디테일 감춤
* - 유연성 : 다른 차종 쉽게 추가 가능.
*
* 추상화를 사용하지 않는 경우
* - 문제점
* 1) 코드 좁고 : 비슷한 기능 반복 사용
* 2) 복잡성 증가 : 모든 세부사항 직접 관리
* 3) 유지보수 어려움 : 차종마다 코드 수정 필요
* - 예: car마다 accelerate()의 이름을 다르게 작성하면 통일성이 사라지게 되며 이를 조작하는 것이 쉽지 않아진다.
* */
public class Application {
    public static void main(String[] args) {
        Dog dog = new Dog("바둑이");
        Cat cat = new Cat("호떡이");

        dog.makeSound();
        cat.makeSound();
    }
}
