package com.ohgiraffers.oop.chap05.section02;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍!");
    }

    public void guard() {
        System.out.println("강아지가 집을 지킨다.");
    }
}
