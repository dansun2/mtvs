package com.ohgiraffers.oop.chap05.section02;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }

    public void catchMouse() {
        System.out.println("고양이가 쥐를 잡는다.");
    }

    @Override
    public String toString() {
        return "고양이";
    }
}
