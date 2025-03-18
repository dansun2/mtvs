package com.ohgiraffers.chap01.section03.model;

import com.ohgiraffers.chap01.section03.service.Rechargeable;

public class SmartPhone extends PortableDevice implements Rechargeable {
    public SmartPhone(String model) {
        super(model);
    }

    @Override
    public void recharge() {
        System.out.println(this.getModel()+" 충전중");
    }
}
