package com.ohgiraffers.oop.chap01.basic2;

public class TicketWithoutConstructor {
    public String movieName;
    public String seatNumber;

    public void printTicket() {
        System.out.print("영화 제목 : " + movieName);
        System.out.print("좌석 번호 : " + seatNumber);
        System.out.println("으로 티켓이 발급되었습니다.");
        /*
        * 생성자를 따로 만들지 않아도 기본적으로 자바에서 컴파일하며 생성자를 만들어줌
        * 그리고 void는 반환값은 없지만 자동으로 return을 시켜줌 (함수가 끝날때 return단계는 필수!)
        * */
    }
}
