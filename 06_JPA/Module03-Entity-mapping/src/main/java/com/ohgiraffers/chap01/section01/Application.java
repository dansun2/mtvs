package com.ohgiraffers.chap01.section01;

import com.ohgiraffers.chap01.section01.model.Customer;
import com.ohgiraffers.chap01.section01.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // 트랜잭션 시작
        tx.begin();

        try {
            Customer customer = new Customer("홍길동");
            em.persist(customer);

            Order order = new Order(customer);
            em.persist(order);

            tx.commit();

            em.clear(); // 연관관계 옵션에서 Lazy 를 실행하기 위해. 왜냐면 이미 위에서 persist로 영속성컨텍스트에 넣어줬기때문에 확인을 위해 clear

            Order foundOrder = em.find(Order.class, order.getOrderId());
            System.out.println(" ---- customer 조회하기 이전 ----");
            System.out.println(foundOrder);

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
