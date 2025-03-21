package com.ohgiraffers.z_activity.mission;

import com.ohgiraffers.z_activity.mission.model.Book;
import com.ohgiraffers.z_activity.mission.model.BookCheckOutList;
import com.ohgiraffers.z_activity.mission.model.Member;
import com.ohgiraffers.z_activity.mission.util.LogManager;

import java.util.List;
import java.util.Scanner;

public class BookApplication {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Clean Code", "Robert C. Martin", true),
                new Book("Effective Java", "Joshua Bloch", true)
        );

        List<Member> members = List.of(
                new Member("Alice", "LM001"),
                new Member("Bob", "LM002")
        );

        List<BookCheckOutList> bookCheckOutLists = List.of(
                new BookCheckOutList("Alice","Clean Code",false),
                new BookCheckOutList("Bob","Effective Java", true)
        );

        Scanner sc = new Scanner(System.in);
        System.out.print("회원 이름을 입력하세요 : ");
        String memberName = sc.nextLine(); // 회원이름 받음
        System.out.print("책 이름을 입력하세요 : ");
        String bookTitle = sc.nextLine(); // 책 제목 받음
        String result = "";

        // 책 대여 목록중에 찾아보기
        for (BookCheckOutList bookCheckOutList : bookCheckOutLists) {
//            System.out.println(bookCheckOutList);
            // 사용자가 입력한 책과 같은 책 확인
            if (bookCheckOutList.getTitle().equals(bookTitle)) {
                result = bookCheckOutList.statusCheck(memberName, bookTitle);
            }
        }
        System.out.println(result);

        // transaction.log 파일에 대출, 반납기록 저장하기
        // result를 넣으면 될 듯
        String filePath = "";
        LogManager.logTransaction(result,"transaction.log");
    }
}
