package com.ohgiraffers.oop.chap01.basic2;

public class MoiveTicket {
    public String movieName;
    public String seatNumber;

    // 생성자의 규칙
    // [접근제어자] [클래스명] (매개변수) {범위}
    public MoiveTicket(String movieName, String seatNumber) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
    }

    public void printTicket() {
        System.out.print("영화 제목 : " + movieName);
        System.out.print("좌석 번호 : " + seatNumber);
        System.out.println("으로 티켓이 발급되었습니다.");
    }
}
