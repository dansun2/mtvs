package com.ohgiraffers.chap01.section03.model;

public class PortableDevice extends Device {
    public PortableDevice(String model) {
        super(model);
    }

    @Override
    public void powerOn() {
        System.out.println(this.getModel() + " 전원이 켜짐(휴대기기)");
    }

    @Override
    public void powerOff() {
        System.out.println(this.getModel() + " 전원이 꺼짐(휴대기기)");
    }
}
