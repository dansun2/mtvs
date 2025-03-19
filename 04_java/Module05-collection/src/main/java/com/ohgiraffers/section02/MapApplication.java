package com.ohgiraffers.section02;

import java.util.HashMap;
import java.util.Map;

public class MapApplication {
    public static void main(String[] args) {
        Map<Integer, String> bookMap = new HashMap<Integer, String>();
        bookMap.put(1, "자바의 정석");
        bookMap.put(2, "클린 코드");
        bookMap.put(3, "Effective Java");

//        Map<String,String> mapTest = new HashMap<>();
//        mapTest.put("일번", "자바의 정석");

        System.out.println(bookMap);

        // 요소 접근
        String book = bookMap.get(1); // 인덱스 번호가 아니고 키 번호
        System.out.println("키 1번에 해당하는 책 : "+book);

        // 요소 삭제
        bookMap.remove(2);
        System.out.println(bookMap);

        // Map의 크기 확인
        System.out.println("현재 hashMap의 크기 "+bookMap.size());

        for (Map.Entry<Integer,String> entry : bookMap.entrySet()) { // 키+밸류가 하나의 객체이다
            System.out.println("키 : " + entry.getKey() + ", 값 : " + entry.getValue());
        }

        if (bookMap.containsKey(3)) {
            System.out.println("키 값 중 3이 존재하는가? "+bookMap.get(3));
        } else {
            System.out.println("3인 키 값은 존재하지 않습니다.");
        }

        if (bookMap.containsValue("클린 코드")) {
            System.out.println("bookMap에 클린 코드가 존재합니다.");
        } else {
            System.out.println("bookMap에 클린 코드가 존재하지 않습니다.");
        }
    }
}
