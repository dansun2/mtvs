package com.ohgiraffers.oop.chap03.inheritance.deep;
/*
* 컴포지션 이란?
* - 상속 대신 객체를 포함해서 기능을 사용하는 방법이다.
* - has-a 관계 클래스 안에 다른 객체를 넣는다.
* - 비유: 차에 엔진을 물려받는 대신 장착하는 것
*
* 컴포지션의 장점
* - 느슨한 결합 : 포함된 객체를 쉽게 교체할 수 있다.
* - 재사용성 : Engine을 다른 car에서도 사용할 수 있다.
* - 성능 : 불필요한 부모 필드 없이 필요한 것만 포함
* */
public class Application {
    public static void main(String[] args) {
        Car car = new Car(new Engine()); // 여기서 Car는 내연기관을 의미하는데 내연기관 차는 엔진을 포함한다.
        car.drive();
    }
}
