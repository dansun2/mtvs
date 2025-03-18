package com.ohgiraffers.chap01.section03.service;

public interface Bluetooth {
    boolean CONNECTED = true;

    void connect(); // 블루투스 연결
    void disConnect(); // 연결 해제

}
