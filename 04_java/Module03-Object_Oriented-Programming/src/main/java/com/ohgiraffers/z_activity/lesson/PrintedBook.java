package com.ohgiraffers.z_activity.lesson;

public class PrintedBook extends Book {
    private double shippingCost;

    public PrintedBook(String title, String author, Double besePrice, double shippingCost) {
        super(title, author, besePrice);
        this.shippingCost = shippingCost;
    }

    @Override
    public double getFinalPrice() {
        return super.getBasePrice() + shippingCost;
    }
}
