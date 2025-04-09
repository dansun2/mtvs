package com.ohgiraffers.jpql.chap01.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

/*
* jpql이 없다면 발생하는 문제
* 제공된 테이블을 기반으로 데이터를 조회하려면 native SQL에 의존해야 한다.
* 이는 객체 지향적이지 않고, 테이블명/컬럼명에 직접 의존하기 때문에 유지보수가 어렵다.
* "가격이 200원 이상인 강좌"를 조회하려면 SQL을 작성해야 하며, 결과가 Object[]로 타입의 안정성이 떨어지게 된다.
* */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();

        String sql = "SELECT * FROM courses WHERE price >= 300";
        List<Object[]> result = em.createNativeQuery(sql).getResultList();
        System.out.println(result.size());

        System.out.println();

        for (Object[] row : result) {
            System.out.println("course Id : " + row[0] + ", title : " + row[1]);
        }

        List<Object[]> result2 = em.createNativeQuery(sql).getResultList();
        em.close();
        emf.close();
    }
}
