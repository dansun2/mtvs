package com.ohgiraffers.z_activity.mission.service;

import com.ohgiraffers.z_activity.lesson.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalManager {
    // 회원의 membershipID별로 대여한 책 목록(List<Book>)을 저장하는 Map
    private Map<String, List<Book>> rentalBooks;

    // 생성자 : 외부에서 rentalBooks를 주입받아 초기화 할 때 사용
    public RentalManager(Map<String, List<Book>> rentalBooks) {
        this.rentalBooks = rentalBooks;
    }

    // 기본 생성자 : rentalBooks를 빈 HashMap으로 초기화
    public RentalManager() {
        this.rentalBooks = new HashMap<>();
    }

    public void rentBook(String membershipId, Book book) {

        // 회원이 이미 존재하는경우(책을 이미 대여한 경우)
        // map에서 containsKey는 equals랑 같다. 문자열이 포함된것을 찾는게 아니고 Key 중에 이런 문자열을 갖는 키가 있는지 찾음
        if(rentalBooks.containsKey(membershipId)) {
            rentalBooks.get(membershipId).add(book); // 기존 책 목록 List<Book>에 새 책 추가
        } else { // 회원이 없으면 새롭게 맵에 키(membershipID)-값(Book)을 넣어줌.
            // 책을 넣으려면 새 리스트 필요
            List<Book> books = new ArrayList<>();
            books.add(book); // 리스트에 대여할 책 추가
            rentalBooks.put(membershipId, books); // 대여할 책과 회원ID를 Map에 추가
        }
    }

    public String getRentalList(String membershipId) {
        String result = "";
        String titleList = "";

        // Map의 모든 키-값을 돌림
        for (Map.Entry<String, List<Book>> entry : rentalBooks.entrySet()) {
            result += "회원ID: " + entry.getKey() + " -> 대여 도서: ";
            if (entry.getKey().equals(membershipId)) { // membershipId와 동일한 key를 Map에서 찾는다~
                // membershipId가 포함된 key가 있으면 value(List타입의 Book객체)에서 getTitle을 전부 가져올건데

                // List 형식의 Book 객체를 만들어서 Map의 value 값을 넣어주고
                // 만든 book객체를 for-each로 하나하나 돌리면서 result 에 문자열을 더함
                List<Book> list = entry.getValue(); // 회원이 대여한 책 목록을 전부 가져옴
                for (Book book : list) {
                    titleList += book.getTitle() + "; "; // titleList에 하나하나 추가
                }
            }
        }
        return result+titleList;
    }
}
