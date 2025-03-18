package com.ohgiraffers.chap02.lesson.model;

import com.ohgiraffers.chap02.lesson.service.Discountable;

public class Ebook extends Book implements Discountable {
    private final double discountRate;

    public Ebook(String title, String author, double price, double discountRate) {
        super(title, author, price);
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscountedPrice() {
        return super.getPrice() - (super.getPrice() * discountRate);
    }
}
