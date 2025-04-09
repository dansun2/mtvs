package com.ohgiraffers.inheritance.chap01.section04;

import com.ohgiraffers.inheritance.chap01.section04.model.ClothingProductTPC;
import com.ohgiraffers.inheritance.chap01.section04.model.ElectronicProductTPC;
import com.ohgiraffers.inheritance.chap01.section04.model.FoodProductTPC;
import com.ohgiraffers.inheritance.chap01.section04.model.ProductTPC;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

/*
* TABLE_PER_CLASS 전략
* - 각 클래스를 별도의 테이블로 저장
* - 장점 : 조인이 없으므로 조회 성능 빠름
* - 단점 공통 속성이 중복 저장되어 스토리지 낭비가 발생함. 공통 속성 변경 시 모든 테이블 수정 필요
*
* DB 에서 개별 테이블 관리
* - 데이터베이스에서는 각 자식 클래스가 독립적인 테이블로 저장됨
* - 부모 클래스의 속성도 각 자식 테이블에 포함됨
* ㄱ- 부모 클래스에 해당하는 테이블은 생성되지 않음.
* - 조회 시 각 테이블에서 데이터를 직접 가져옴
* - 단, 공통 속성이 각 테이블에 저장되어 데이터 중복 발생
* */
public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            ElectronicProductTPC electronic = new ElectronicProductTPC("Laptop", 999.99, "TechBrand", 50, 24, "65W");
            em.persist(electronic);

            // 의류 저장
            ClothingProductTPC clothing = new ClothingProductTPC("T-Shirt", 19.99, "FashionBrand", 100, "M", "Cotton", "Blue");
            em.persist(clothing);

            // 식품 저장
            FoodProductTPC food = new FoodProductTPC("Milk", 2.99, "FoodBrand", 200, LocalDate.now().plusDays(7), true, "Refrigerate at 4°C");
            em.persist(food);

            em.flush();
            em.clear();



            // 각 테이블에서 개별 조회
            System.out.println("TABLE_PER_CLASS 전략으로 조회 (전자제품):");
            em.createQuery("SELECT e FROM ElectronicProductTPC e", ElectronicProductTPC.class)
                    .getResultList()
                    .forEach(System.out::println);

            System.out.println("TABLE_PER_CLASS 전략으로 조회 (의류):");
            em.createQuery("SELECT c FROM ClothingProductTPC c", ClothingProductTPC.class)
                    .getResultList()
                    .forEach(System.out::println);

            System.out.println("TABLE_PER_CLASS 전략으로 조회 (식품):");
            em.createQuery("SELECT f FROM FoodProductTPC f", FoodProductTPC.class)
                    .getResultList()
                    .forEach(System.out::println);



            // 부모타입을 기준으로 모든 자식 테이블을 조회할 수 있다.
            // 해당 단계에서는 Union ALL을 사용하여 모든 데이터를 취합하는 방식을 사용한다.
            // 이것은 @MappedSuperclass와 결정적인 차이이다.
            System.out.println("\nTABLE_PER_CLASS 전략으로 부모 타입 조회:");
            List<ProductTPC> allProducts = em.createQuery("SELECT p FROM ProductTPC p", ProductTPC.class)
                    .getResultList();
            allProducts.forEach(product -> System.out.println("Product: " + product));


            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
