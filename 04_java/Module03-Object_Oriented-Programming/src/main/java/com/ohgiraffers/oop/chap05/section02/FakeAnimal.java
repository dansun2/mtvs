package com.ohgiraffers.oop.chap05.section02;

public class FakeAnimal {
    public void makeSound() {
        System.out.println("하하하 나는 가짜 동물이다");
    }

    @Override
    public String toString() {
        return "난 동물이 아니야";
    }
}
