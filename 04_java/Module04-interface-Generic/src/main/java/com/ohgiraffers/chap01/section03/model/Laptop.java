package com.ohgiraffers.chap01.section03.model;

import com.ohgiraffers.chap01.section03.service.Rechargeable;

public class Laptop extends PortableDevice implements Rechargeable {
    public Laptop(String model) {
        super(model);
    }

    @Override
    public void recharge() {
        System.out.println(this.getModel()+" 충전중");
    }
}
