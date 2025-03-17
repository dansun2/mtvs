package com.ohgiraffers.oop.chap05.section01;
/*
* 다형성을 사용하지 않으면 생기는 문제
*   1) 코드 중복 : 각 동물마다 별도의 변수와 호출이 필요
*   2) 유지보수 어려움 : 새 동물 추가 시 코드 반복 수정
*   3) 통합 관리 불가 : 동물들을 한꺼번에 다룰 방법이 없음
* - 비유 : 동물원에서 개, 고양이를 따로 불러야 하는 번거로움이 생기게 됨
* */
public class Application {
    public static void main(String[] args) {
        Dog dog = new Dog("바둑이");
        Cat cat = new Cat("호떡이");

        dog.makeSound();
        cat.makeSound();
    }
}
