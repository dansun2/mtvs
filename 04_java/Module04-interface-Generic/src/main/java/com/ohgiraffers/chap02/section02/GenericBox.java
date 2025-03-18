package com.ohgiraffers.chap02.section02;
/*
* 기본 문법
* - 클래스 선언 : class Box<T> {T item;} -> T는 타입 파라미터
* - 객체 생성 : Box<String> box = new Box(); -> String만 포함할 수 있음
* - T는 빈칸, 사용 시점에 타입을 지정할거야!
* */
public class GenericBox<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }
}
