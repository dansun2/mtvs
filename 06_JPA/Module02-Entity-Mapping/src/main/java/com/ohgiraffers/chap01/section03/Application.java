package com.ohgiraffers.chap01.section03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

// 진행 전 lecture_db.sql 파일 실행 후 사용
// value object 내용을 잠시 다루고 깊은 설명과 이해는 Module04에서 진행한다.
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();

        //  조회 조회
//        selectProduct(em);
        // 등록
//        insertProduct(em);

        // 수정
        updateProduct(em);
        em.close();
        emf.close();

    }

    public static void selectProduct(EntityManager em) {
        Product user = em.getReference(Product.class, 1);
        System.out.println(user);
    }

    public static void insertProduct(EntityManager em) {
        em.getTransaction().begin();

        Manufacturer samsung = new Manufacturer("Samsung", "Korea");
        Money price = new Money(new BigDecimal("999.99"), "USD");
        Product product = new Product("Galaxy S25", price, samsung);
        em.persist(product);
        System.out.println(product);
        em.getTransaction().commit();
    }


    public static void updateProduct(EntityManager em) {
        em.getTransaction().begin();
        Product foundProduct = em.find(Product.class, 1);
        System.out.println("✅ 초기 상태: " + foundProduct);
        System.out.println("초기 가격의 hash : " + foundProduct.getPrice().hashCode());
        System.out.println("초기 제조사의 hash : " + foundProduct.getManufacturer().hashCode());


        // 📌 가격 변경 (값 객체 교체 방식)
        Money newPrice = new Money(new BigDecimal("899.99"), "USD");
        foundProduct.changePrice(newPrice);

        // 📌 제조사 변경 (값 객체 교체 방식)
        Manufacturer newManufacturer = new Manufacturer("LG", "Korea");
        foundProduct.changeManufacturer(newManufacturer);

        em.getTransaction().commit();

        // 📌 최종 상태 확인
        System.out.println("✅ 변경 후 상태: " + foundProduct);
        System.out.println("변경 후 가격 hash : " + foundProduct.getPrice().hashCode());
        System.out.println("변경 후 제조사 hash : " + foundProduct.getManufacturer().hashCode());
    }
}