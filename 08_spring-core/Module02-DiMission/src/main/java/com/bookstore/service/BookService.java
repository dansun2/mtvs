package com.bookstore.service;

import org.springframework.stereotype.Component;

@Component
public class BookService implements BookRepository{

    @Override
    public String findBookById(String bookId) {
        return "책ID: " + bookId;
    }
}
