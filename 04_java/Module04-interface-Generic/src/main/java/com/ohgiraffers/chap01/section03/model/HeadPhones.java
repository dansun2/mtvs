package com.ohgiraffers.chap01.section03.model;

import com.ohgiraffers.chap01.section03.service.Bluetooth;
import com.ohgiraffers.chap01.section03.service.Rechargeable;

public class HeadPhones extends PortableDevice implements Rechargeable, Bluetooth {
    public HeadPhones(String model) {
        super(model);
    }

    @Override
    public void recharge() {
        System.out.println(this.getModel()+" 충전중");
    }

    @Override
    public void connect() {
        if (CONNECTED) {
            System.out.println(this.getModel()+" 블루투스 연결됨");
        }
    }

    @Override
    public void disConnect() {
        boolean disConnected = !CONNECTED; // 메서드가 실행되면 연결을 해제시켜주는 부분
        if (!disConnected) {
            System.out.println(this.getModel()+" 블루투스 연결 해제됨");
        }
    }
}
