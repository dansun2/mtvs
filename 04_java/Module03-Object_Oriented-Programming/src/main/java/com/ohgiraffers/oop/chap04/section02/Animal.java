package com.ohgiraffers.oop.chap04.section02;
/*
* 추상화란?
* - 복잡한 세부 사항을 숨기고, 핵심 기능만 정의하는 방법이다.
*   쉽게 설명하면 인터페이스만 정의하고 "나를 상속받는 너희들이 구현해" 라는 말이다.
*   이를 사용하면 세부 내용은 달라도 동일한 이름으로 실행할 수 있게 된다.
* - 비유 : 동물에게 "짖어"라고 한다면, 어떤 소리를 낼 지는 몰라도 소리가 나온다.
* */
public abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    /*
    * abstract 키워드
    * - 클래스나 메서드를 "추상적"으로 만듦.
    * - abstract 는 불완전한 클래스로 해당 클래스의 인스턴스를 생성할 수 없게 되며,
    *   이를 상속받는 클래스에서는 반드시 불완전한 요소를 해결해야 한다.
    *   이러한 것을 "구현 책임의 원칙"이라고 한다.
    *
    * - abstract 메서드 : 몸체가 없으며, 자식 클래스에서 반드시 구현해야 한다.
    * - 문법 [접근제어자] abstract 반환타입 메서드명(); <- 여기서 몸체는 따로 만들지 않는다.
    * */

    public abstract void makeSound(); // abstract 추상메서드. abstract를 쓰려면 class 앞단에 abstract를 붙여줘야함.
}
