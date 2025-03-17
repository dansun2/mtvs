package com.ohgiraffers.oop.chap04.section01;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println(this.name + "이 울음 소리를 냅니다. 멍멍");
    }


}
