package com.ohgiraffers.chap02.mission;

import com.ohgiraffers.chap02.mission.model.Book;
import com.ohgiraffers.chap02.mission.service.Searchable;

public class LibrarySearch {
    public static void main(String[] args) {
        Searchable[] searchable = new Searchable[] {
                (new Book("자바 책","저자",5000)),
                (new Book("만화책", "그림그린사람",4500)),
                (new Book("자바 딥하게 공부하는 책","누가썼어",3000))
        };
        String keyword = "자바";
        LibrarySearch.searchBooks(searchable, keyword);
    }

    public static String[] searchBooks(Searchable[] books, String keyword) {
        String[] bookInfo = {};
        for (Searchable book : books) {
            boolean result = book.matches(keyword);
            if (result) {
                System.out.println(book);
            }
        }
        return bookInfo;
    }
}
