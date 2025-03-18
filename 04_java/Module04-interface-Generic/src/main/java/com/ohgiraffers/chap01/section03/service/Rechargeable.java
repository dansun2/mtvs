package com.ohgiraffers.chap01.section03.service;

public interface Rechargeable {
    void recharge();

    // 충전 할 수 있음/없음으로 분리해야 하는 건 맞지만 충전 방식이 크게 다르지 않음 JDK11부터 추가된 기능
    // 클래스에서 충전방식이 좀 다르다 하면 오버라이딩 해서 쓰면 된다.
    default void DefaultRecharge() {
        System.out.println("기본 충전중!");
    }

}
