package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final BookService bookService;

    @Autowired
    public OrderService(BookService bookService) {
        this.bookService = bookService;
    }

    public String placeOrder(String bookId) {
        String result = bookService.findBookById(bookId);
        System.out.println(result);
        return result;
    }
}
