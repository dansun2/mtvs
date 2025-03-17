package com.ohgiraffers.oop.chap03.section02;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("월월!! 월월!!");
    }
}
