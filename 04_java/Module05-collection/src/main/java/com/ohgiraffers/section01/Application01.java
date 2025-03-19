package com.ohgiraffers.section01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application01 {
    public static void main(String[] args) {
        List<String> bookList = new ArrayList<String>();
        bookList.add("자바의 정석");
        bookList.add("클린 코드");
        bookList.add("자바의 정석");

        // 중복값을 허용한다.
        System.out.println(bookList);

        /*
        * - add()는 리스트 끝에 요소 추가, 기본 O(1) 시간 복잡도.
        * - 메모리 : bookList는 스택에 참조, 데이터는 힙의 동적 배열에 저장
        * */

        // 요소 접근 : 요소의 인덱스를 참조하여 데이터를 꺼내올 수 있다.
        String firstBook = bookList.get(0);
        System.out.println("첫 번째 책 : "+firstBook);

        // 요소 삭제 : 0번째 책이 삭제됨
        bookList.remove(0);
        System.out.println("수정된 bookList : "+bookList);

        // 요소 수정 : 0번째 값이 클린코드 -> Effective Java 로 변경
        bookList.set(0,"Effective Java");
        System.out.println(bookList);

        // List 의 길이를 확인
        System.out.println("현재 bookList의 길이 : "+bookList.size());

        // List 초기화
        bookList.clear();
        System.out.println("초기화 "+bookList);

        bookList.add("c");
        bookList.add("a");
        bookList.add("b");
        System.out.println("정렬 이전 : "+bookList);

        System.out.println("List 정렬하기");
        Collections.sort(bookList);
        System.out.println("정렬 이후 : "+bookList);

        // 제네릭으로 인해 타입이 고정되어 다음과 같이 for 문을 사용할 수 있다.
        for (String s : bookList) {
            System.out.println(s);
        }
    }
}
