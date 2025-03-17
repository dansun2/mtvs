package com.ohgiraffers.z_activity;

public class BookInventoryCalculator {
    private Book[] books;

    public BookInventoryCalculator(Book[] books) {
        this.books = books;
    }

    public String calculateInventory() {
        double totalPrice = 0;
        double highestPrice = 0;
        double lowestPrice = 0;
        String highestPriceString = "";
        String lowestPriceString = "";

        int length = books.length;
        for (int i = 0; i < length; i++) {
            double price = books[i].getBasePrice();
            totalPrice += price;

            if (price > highestPrice) {
                highestPrice = price;
                highestPriceString = books[i].getTitle();
            }

            if (price < lowestPrice) {
                lowestPrice = price;
                lowestPriceString = books[i].getTitle();
            }
        }
        double averagePrice = totalPrice / length;
        return "총 재고 가치 : " + totalPrice + ", 평균 가격 : " + averagePrice + ", 최고가 도서 : "
                + highestPriceString + ", 최저가 도서 : " + lowestPriceString;
    }
}
