package com.ohgiraffers.z_activity.lesson;

public class Application {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new PrintedBook("Java Programing", "Author", 50.0, 5000),
                new Ebook("Effective Java", "Author B", 70.00, 0.1),
                new PrintedBook("Clean Code", "Author C", 65.0, 5000)
        };

        BookInventoryCalculator calculator = new BookInventoryCalculator(books);
        System.out.println(calculator.calculateInventory());
    }
}
