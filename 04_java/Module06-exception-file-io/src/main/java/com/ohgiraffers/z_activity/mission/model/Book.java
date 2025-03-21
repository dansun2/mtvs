package com.ohgiraffers.z_activity.mission.model;

public class Book {
    private String title;
    private String author;
    private boolean checkOutStatus;

    public Book(String title, String author, boolean checkOutStatus) {
        this.title = title;
        this.author = author;
        this.checkOutStatus = checkOutStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", checkOutStatus=" + checkOutStatus +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckOutStatus() {
        return checkOutStatus;
    }

    public void setCheckOutStatus(boolean checkOutStatus) {
        this.checkOutStatus = checkOutStatus;
    }
}
