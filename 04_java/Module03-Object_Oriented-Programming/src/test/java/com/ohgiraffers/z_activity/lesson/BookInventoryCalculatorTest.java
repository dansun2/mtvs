package com.ohgiraffers.z_activity.lesson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookInventoryCalculatorTest {
    private BookInventoryCalculator bookInventoryCalculator;
    private Book[] books;

    @BeforeEach
    void setUp () {
        books = new Book[]{
                new PrintedBook("Java Programing", "Author", 50.0, 5.0),
                new Ebook("Effective Java", "Author B", 70.00, 0.1),
                new PrintedBook("Clean Code", "Author C", 65.0, 7.0)
        };
        bookInventoryCalculator = new BookInventoryCalculator(books);
    }

    @Test
    void testBookInventoryCalculator () {
        String result = bookInventoryCalculator.calculateInventory();

        Assertions.assertTrue(result.contains("총 재고 가치 : 185.0"));
        Assertions.assertTrue(result.contains("최고가 도서 : Clean Code"));
        Assertions.assertTrue(result.contains("최저가 도서 : Java Programing"));
    }

    @AfterEach
    void tearDown () {
        books = null;
        bookInventoryCalculator = null;
    }

}