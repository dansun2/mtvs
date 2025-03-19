package com.ohgiraffers.z_activity.lesson;

import com.ohgiraffers.z_activity.lesson.model.Book;
import com.ohgiraffers.z_activity.lesson.service.BookManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookServiceTests {
    private BookManager bookManager;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        bookManager.addBook(new Book("Clean code", "Robert C. Martin", 45.0));
        bookManager.addBook(new Book("Effective Java", "Joshua", 55.0));
    }

    @AfterEach
    public void tearDown() {
        bookManager = null;
    }

    @Test
    public void testAddBook() {
        String list = bookManager.listBooks();
        Assertions.assertTrue(list.contains("Clean code"));
        Assertions.assertTrue(list.contains("Effective Java"));
    }

    @Test
    public void testRemoveBook() {
        boolean removed = bookManager.removeBook("Clean code");
        Assertions.assertTrue(removed);

        String list = bookManager.listBooks();
        Assertions.assertFalse(list.contains("Clean code"));
    }
}
