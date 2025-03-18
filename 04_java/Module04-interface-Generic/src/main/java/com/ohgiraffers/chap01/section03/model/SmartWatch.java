package com.ohgiraffers.chap01.section03.model;

import com.ohgiraffers.chap01.section03.service.Bluetooth;
import com.ohgiraffers.chap01.section03.service.Rechargeable;

public class SmartWatch extends PortableDevice implements Rechargeable, Bluetooth {
    public SmartWatch(String model) {
        super(model);
    }

    @Override
    public void recharge() {
        System.out.println(this.getModel()+" 스마트워치 충전중");
    }

    @Override
    public void connect() {
        System.out.println(this.getModel()+" 스마트워치 블루투스 연결됨");
    }

    @Override
    public void disConnect() {
        System.out.println(this.getModel()+" 스마트워치 블루투스 연결해제됨");
    }
}
