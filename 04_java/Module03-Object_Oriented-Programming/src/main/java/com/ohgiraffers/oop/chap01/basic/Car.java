package com.ohgiraffers.oop.chap01.basic;
/*
* 클래스(class)란
* - 객체(Object)를 생성하기 위한 설계도
* - 변수(필드)와 메서드(기능)을 포함한다.
*
* 객체란
* - 클래스에 의해 생성된 "실제 사용 가능한 실체"
* - 필드와 메서드를 포함하며, 상태(state)와 행동(behavior)를 가진다.
*
* 문법 구조
* [접근제어자] class [클래스이름] {
*   // 필드
*   // 메서드
* }
* */
public class Car {

    // 필드(속성)
    public String brand;
    public String model;
    public int speed;

    public void accelerate() {
        speed += 10;
        System.out.println(brand + " " + model + "의 속도 : " + speed);
    }

    public void brake() {
        speed -= 10;
        System.out.println(brand + " " + model + "의 속도 : " + speed);
    }
}
