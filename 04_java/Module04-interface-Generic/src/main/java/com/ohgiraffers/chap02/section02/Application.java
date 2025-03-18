package com.ohgiraffers.chap02.section02;
/*
* 제네릭스란?
* - 클래스나 메서드에서 사용할 "타입"을 나중에 지정할 수 있게 해주는 기능
* - 타입 파라미터(T)를 사용해서 객체를 만들 때 타입을 정함
* - 비유 : 상자(box)를 만들 때, 안에 넣을 물건(타입)을 나중에 정하는 것!
*
* 제네릭스가 필요한 이유
* - 제네릭스 없이 상자를 만들면 모든 물건(Object)을 넣을 수 있지만, 꺼낼 때 형변환이 필요하다. -> 실수하면 런타임 오류 발생
*   예 : Object Box 에 String 을 넣고 꺼낼 때 Integer 로 형변환하면 오류
* - 제네릭스는 타입을 미리 정해서 이런 실수를 컴파일 때 잡아준다.
* 
* 이해의 기준
* 초급 : 잘못된 물건을 못 넣게 해줄 수 있다.
* 중급 : 형변환 안 해도 돼서 코드가 간단해진다.
* 고급 : 타입의 안정성 확보로 런타임 오류를 방지
* */
public class Application {
    public static void main(String[] args) {
        System.out.println("제네릭 상자");
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setItem("Hello world");
        String hell = stringBox.getItem();
        System.out.println(hell+"라고 인사");

        // 오류 발생
//        stringBox.setItem(123);

        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.setItem(123);
        int number = intBox.getItem();
        System.out.println("꺼낸 값 : "+number);

//        intBox.setItem("hello");
    }
}
