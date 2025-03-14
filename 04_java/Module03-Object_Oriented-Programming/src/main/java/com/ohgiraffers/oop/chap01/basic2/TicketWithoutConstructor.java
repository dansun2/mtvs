package com.ohgiraffers.oop.chap01.basic2;

public class TicketWithoutConstructor {
    public String movieName;
    public String seatNumber;

    public void printTicket() {
        System.out.print("영화 제목 : " + movieName);
        System.out.print("좌석 번호 : " + seatNumber);
        System.out.println("으로 티켓이 발급되었습니다.");
    }
}
