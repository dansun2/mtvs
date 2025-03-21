package com.ohgiraffers.z_activity.team_mission.model;

import java.time.LocalDate;
// 책 대출 기록 클래스
public class BookCheckOut {
    private int memberId;
    private int boodId;
    private LocalDate checkOutDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BookCheckOut(int memberId, int boodId, LocalDate checkOutDate, LocalDate dueDate, LocalDate returnDate) {
        this.memberId = memberId;
        this.boodId = boodId;
        this.checkOutDate = checkOutDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return  "회원ID '" + memberId +
                "'님의 책 '" + boodId +
                "'의 대여일은 " + checkOutDate +
                ", 반납 예정일은 " + dueDate +
                ", 반납일은 " + returnDate +
                "입니다.";
    }
}
