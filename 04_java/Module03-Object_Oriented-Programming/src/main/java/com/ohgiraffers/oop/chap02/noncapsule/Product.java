package com.ohgiraffers.oop.chap02.noncapsule;
/*
* 무결성이란?
* 데이터 무결성은 데이터가 정확하고 일관되며 신뢰할 수 있는 상태를 유지
* */
public class Product {

    public double payment;

    public String selling(int payment) {
        String message;
        if (payment == 0) {
            message = "냅둬유 그냥 개나 주게";
        } else if (payment < 0) {
            message = "장사는 뭐더러혀 어차피 넘 주는디";
        } else {
            message = this.payment + "에 가지고 가려면 그러든가.";
        }
        return message;
    }
}
