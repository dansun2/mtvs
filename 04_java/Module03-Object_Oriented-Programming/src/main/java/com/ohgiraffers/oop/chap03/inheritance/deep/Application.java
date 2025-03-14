package com.ohgiraffers.oop.chap03.inheritance.deep;

public class Application {
    public static void main(String[] args) {
        Car car = new Car(new Engine());
        car.drive();
    }
}
