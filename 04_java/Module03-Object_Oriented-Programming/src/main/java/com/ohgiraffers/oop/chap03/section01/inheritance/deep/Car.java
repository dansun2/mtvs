package com.ohgiraffers.oop.chap03.section01.inheritance.deep;

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

    public Car setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }
}
