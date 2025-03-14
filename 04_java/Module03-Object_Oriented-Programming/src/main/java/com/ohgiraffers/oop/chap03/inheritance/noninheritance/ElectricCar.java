package com.ohgiraffers.oop.chap03.inheritance.noninheritance;

public class ElectricCar extends Car {
    private int batteryLevel;

    public ElectricCar(String brand, int speed, int batteryLevel) {
        super(brand, speed);
        this.batteryLevel = batteryLevel;
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " 배터리 충전 완료.");
    }
}
