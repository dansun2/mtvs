package com.ohgiraffers.oop.chap03.inheritance.noninheritance;

public class Car {
    protected String brand;
    private int speed;

    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void accelerate() {
        speed += 10;
        System.out.println(brand + " 속도 : " + speed);
    }
}
