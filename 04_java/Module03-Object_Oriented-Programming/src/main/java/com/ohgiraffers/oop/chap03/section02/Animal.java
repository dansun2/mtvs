package com.ohgiraffers.oop.chap03.section02;
/*
* 메서드 오버라이딩
* - 부모 클래스의 메서드를 자식 클래스에서 재정의할 수 있게 하는 기능
* - 부모 클래스와 동일한 이름과 매개변수를 가져야 한다. -> 이 규칙이 깨지면 다른 메서드가 되거나 오버로딩이 되어버림
* */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}
