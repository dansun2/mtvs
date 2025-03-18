package com.ohgiraffers.chap02.section03.model;

public class FoodBox <T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
