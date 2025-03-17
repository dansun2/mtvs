package com.ohgiraffers.oop.chap04.section01;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println(this.name + "이 울음 소리를 냅니다. 야옹~~");
    }
}
