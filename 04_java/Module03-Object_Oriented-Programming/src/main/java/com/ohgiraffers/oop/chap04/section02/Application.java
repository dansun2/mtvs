package com.ohgiraffers.oop.chap04.section02;
/*
* 추상화를 통한 문제 해결
* - 공통 기능(소리 내기)를 abstract 로 정의
* - 장점
*   1) 중복 제거 : 한 번만 정의
*   2) 단순화 : 세부 구현을 숨김
*   3) 확장이 쉬움 : 새, 코끼리와 같은 동물 추가 시 간단해짐.
* */
public class Application {
    public static void main(String[] args) {
        Dog dog = new Dog("바둑스");
        Cat cat = new Cat("고양스");

        dog.makeSound();
        cat.makeSound();

        Animal animal = dog;
        animal.makeSound();
        animal = cat;
        animal.makeSound();
    }
}
