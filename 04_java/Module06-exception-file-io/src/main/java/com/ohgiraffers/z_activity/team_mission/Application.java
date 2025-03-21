package com.ohgiraffers.z_activity.team_mission;

import com.ohgiraffers.z_activity.team_mission.model.Book;
import com.ohgiraffers.z_activity.team_mission.model.BookCheckOut;
import com.ohgiraffers.z_activity.team_mission.model.Member;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Book book = new Book(1,"어린왕자","생떽쥐뻬리",true);
        System.out.println(book);
        Member member = new Member(1,"seo");
        System.out.println(member);
        System.out.println(LocalDate.now());
        LocalDate checkOutDate = LocalDate.now();
        LocalDate dueDate = checkOutDate.minusDays(5);
        BookCheckOut bookCheckOut = new BookCheckOut(1,1,checkOutDate,dueDate,null);
    }
}
