package com.ohgiraffers.z_activity.lesson;

import com.ohgiraffers.z_activity.lesson.model.Book;
import com.ohgiraffers.z_activity.lesson.model.Member;
import com.ohgiraffers.z_activity.lesson.util.FileStorageManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("clean code", "Robert C. Martin", 45.0),
                new Book("Effective Java", "Joshua Bloch", 55.0)
        );

        List<Member> members = List.of(
                new Member("Alice", "LM001"),
                new Member("Bob", "LM002")
        );

        FileStorageManager.saveBooksToFile(books, "books.txt");
        FileStorageManager.saveMembersToFile(members, "members.txt");

    }
}
