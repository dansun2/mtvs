package com.ohgiraffers.chap01.section04;

import com.ohgiraffers.chap01.section04.model.Customer;
import com.ohgiraffers.chap01.section04.model.Delivery;
import com.ohgiraffers.chap01.section04.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Customer customer = new Customer("심화 고객");
            Order order = new Order();
            customer.addOrder(order); // 주소전달

            Delivery delivery = new Delivery("ready","서울시 심화구");
            order.setDelivery(delivery); // 얕은 복사

            em.persist(customer);

            tx.commit();
            em.clear();
            System.out.println("n+1 문제 실습 : 고객 목록에서 주문 조회");
            List<Customer> customers = em.createQuery("select c from Customer c", Customer.class).getResultList(); // ()안에 들어가는건 SPQL

            for (Customer c : customers) {
                System.out.println("고객의 이름 : " + c.getName());

                // 해당 시점에서 N+1 문제 발생
                System.out.println("주문 수 : " + c.getOrders().size());
            }

            // N+1 문제를 해결하는법
            // jpql 쿼리를 필요한 것만 직접 짜줌
            // 로딩지연옵션
            // 연관관계를 끊음

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
