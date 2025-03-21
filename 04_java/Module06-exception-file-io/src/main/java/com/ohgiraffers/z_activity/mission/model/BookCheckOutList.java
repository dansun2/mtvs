package com.ohgiraffers.z_activity.mission.model;

import java.util.List;

// 책을 대여/반납 할 때 getInfo 메서드로 Book 클래스의 title과 Member 클래스의 name 을 가져와서 대여상태와 같이 새 객체를 만들어야함
public class BookCheckOutList {
    private String name;
    private String title;
    private boolean bookStatus;

    public BookCheckOutList(String name, String title, boolean bookStatus) {
        this.name = name;
        this.title = title;
        this.bookStatus = bookStatus;
    }

    // 대여/반납 상태 변경 메서드임
    public String statusCheck(String memberName, String bookTitle) {
        String result = "";
        if(bookStatus) {
            setBookStatus(false); // 대여중으로 상태 변경
            result = memberName + " / " + bookTitle + " / " + "대출";
        } else {
            setBookStatus(true); // 반납와료로 상태 변경
            result = memberName + " / " + bookTitle + " / " + "반납 완료";
        }
        return result;
    }

    // 책 대여 목록중에 찾아보기 - 수정 필요
    public boolean searchBook(List<BookCheckOutList> bookCheckOutLists, String bookTitle) {
        boolean check = false;
        for (BookCheckOutList bookCheckOutList : bookCheckOutLists) {
            // 사용자가 입력한 책과 같은 책 확인
            if (bookCheckOutList.getTitle().equals(bookTitle)) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    @Override
    public String toString() {
        return "BookCheckOutList{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", bookStatus=" + bookStatus +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
