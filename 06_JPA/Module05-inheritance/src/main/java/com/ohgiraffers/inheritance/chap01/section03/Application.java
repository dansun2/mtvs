package com.ohgiraffers.inheritance.chap01.section03;


import com.ohgiraffers.inheritance.chap01.section03.model.ClothingProductJoined;
import com.ohgiraffers.inheritance.chap01.section03.model.ElectronicProductJoined;
import com.ohgiraffers.inheritance.chap01.section03.model.FoodProductJoined;
import com.ohgiraffers.inheritance.chap01.section03.model.ProductJoined;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

/*
* joined 테이블 전략
* - 부모와 자식 클래스를 각각 테이블로 나누고, 조인으로 연결
* - 장점: 테이블이 정규화되어 데이터 중복이 적고, 각 테이블이 독립적이다
* - 단점 : 조회 시 조인이 필요하기 때문에 성능이 느려질 수 있다.
*
* DB에서 공통 속성의 테이블 분산
* - 데이터베이스에서 부모 클래스(ProductJoined)의 속성을 Products_jopined 테이블에 저장
* - 각 자식 클래스의 속성은 별도의 테이블에 저장
* - 조회 시 부모 테이블 과 자식 테이블을 조인하여 데이터를 가져온다.
* -예 electronicProduct 조회 시 products_joined와 eletroic_productrs_joined를 조인
* */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            // 전자제품 저장
            ElectronicProductJoined electronic = new ElectronicProductJoined("Laptop", "TechBrand", 50, 24, "65W");
            em.persist(electronic);

            // 의류 저장
            ClothingProductJoined clothing = new ClothingProductJoined("T-Shirt",  "FashionBrand", 100, "M", "Cotton", "Blue");
            em.persist(clothing);

            // 식품 저장
            FoodProductJoined food = new FoodProductJoined("Milk",  "FoodBrand", 200, LocalDate.now().plusDays(7), true, "Refrigerate at 4°C");
            em.persist(food);

            em.flush();
            em.clear();

            // 모든 상품 조회
            System.out.println("JOINED 전략으로 조회:");
            em.createQuery("SELECT p FROM ProductJoined p", ProductJoined.class)
                    .getResultList()
                    .forEach(System.out::println);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
