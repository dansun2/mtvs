package com.ohgiraffers.z_activity.lesson;

import com.ohgiraffers.z_activity.lesson.model.Book;
import com.ohgiraffers.z_activity.lesson.service.BookManager;

public class BookService {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.addBook(new Book("Clean code", "Robert C. Martin", 45.0));
        bookManager.addBook(new Book("테스트 책", "테스트", 30.0));
        bookManager.addBook(new Book("테스트 책2222", "테스트222", 30.0));
        bookManager.addBook(new Book("Effective Java", "Joshua", 55.0));
        System.out.println(bookManager.listBooks());

        bookManager.removeBook("테스트 책");
        System.out.println(bookManager.listBooks());
    }
}
