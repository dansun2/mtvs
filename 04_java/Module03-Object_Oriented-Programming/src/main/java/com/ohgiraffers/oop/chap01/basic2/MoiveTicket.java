package com.ohgiraffers.oop.chap01.basic2;

public class MoiveTicket {
    public String movieName; // 전역 변수 혹은 클래스의 인스턴스 변수라고 한다
    public String seatNumber;

    // final 변하지 않는 상수 (변수명을 대문자로).
    // static을 붙이고 안붙이고의 차이 공유한 자원을 여러군데에서 쓸 수 있게 메서드 area 에 적용함
    // 싱크로나이즈 블럭에 대해 공부해보기~~
    public static final int SEATCNT = 100; 

    // 생성자의 규칙
    // [접근제어자] [클래스명] (매개변수) {범위}
    public MoiveTicket(String movieName, String seatNumber) {
        String test; // 지역 변수
        this.movieName = movieName; // this : 힙에 생성된 나
        this.seatNumber = seatNumber;
    }

    public MoiveTicket(String movieName) {
        this.movieName = movieName;
    }

    public MoiveTicket() {
    }

    public void printTicket() {
        System.out.print("영화 제목 : " + movieName);
        System.out.print("좌석 번호 : " + seatNumber);
        System.out.println("으로 티켓이 발급되었습니다.");
    }
}
