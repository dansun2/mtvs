package com.ohgiraffers.valueobject.chap01.section02;

import com.ohgiraffers.valueobject.chap01.section02.model.Reservation;
import com.ohgiraffers.valueobject.chap01.section02.model.vo.GuestCount;
import com.ohgiraffers.valueobject.chap01.section02.model.vo.StayPeriod;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            StayPeriod stayPeriod = new StayPeriod(
                    LocalDate.of(2025,8,9),
                    LocalDate.of(2025,8,8)
            );

            GuestCount guestCount = new GuestCount(2);
            Reservation reservation = new Reservation(
                    "김철수",
                    "101호",
                    guestCount,
                    stayPeriod,
                    5000
            );

            System.out.println("예상 총 가격 : " + reservation.calculateTotalPrice());
            em.persist(reservation);
            tx.commit();
        }catch (IllegalArgumentException e){
            System.out.println("유효하지 않은 값입니다. : " + e.getMessage());
            tx.rollback();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
