package com.ohgiraffers.z_activity.lesson.service;

import com.ohgiraffers.z_activity.lesson.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private final List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public BookManager(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        boolean removed = false;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equals(title)) {
                books.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    public String listBooks() {
        String result = "";
        for (Book book : books) {
            result += "도서: "+book.getTitle() + ", " + book.getAuthor() + ", " + book.getPrice() + "; ";
        }
        return result;
    }
}
