package com.ohgiraffers.oop.chap03.inheritance.deep;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        this.engine.start();
        this.engine.increaseSpeed();
        System.out.println("오빠차 뽑았다~");
    }
}
