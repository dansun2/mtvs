package com.ohgiraffers.z_activity.mission;

import com.ohgiraffers.z_activity.lesson.model.Book;
import com.ohgiraffers.z_activity.mission.service.RentalManager;

public class BookService {
    public static void main(String[] args) {
        RentalManager rentalManager = new RentalManager();
        rentalManager.rentBook("LM001",new Book("Clean code", "Robert C. Martin", 45.0));
        rentalManager.rentBook("LM001",new Book("자바의 정석", "Robert C. Martin", 45.0));
        System.out.println(rentalManager.getRentalList("LM001"));
    }
}
