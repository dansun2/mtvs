package com.ohgiraffers.chap01.section03.model;

public class FixedDevice extends Device {
    public FixedDevice(String model) {
        super(model);
    }

    @Override
    public void powerOn() {
        System.out.println(this.getModel() + " 전원 켜짐(고정기기)");
    }

    @Override
    public void powerOff() {
        System.out.println(this.getModel() + " 전원 꺼짐(고정기기)");
    }
}
