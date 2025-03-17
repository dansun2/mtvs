package com.ohgiraffers.z_activity;

public class Ebook extends Book {
    private double discountRate;

    public Ebook(String title, String author, Double basePrice, double discountRate) {
        super(title, author, basePrice);
        this.discountRate = discountRate;
    }

    @Override
    public double getFinalPrice() {
        return super.getBasePrice() - (getBasePrice() * discountRate);
    }
}
