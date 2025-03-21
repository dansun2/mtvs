package com.ohgiraffers.z_activity.team_mission.model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean bookStatus;

    public Book(int bookId, String title, String author, boolean bookStatus) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return  "책ID:" + bookId +
                ", 제목:" + title +
                ", 저자:" + author +
                ", 대여상태:" + bookStatus;
    }
}
