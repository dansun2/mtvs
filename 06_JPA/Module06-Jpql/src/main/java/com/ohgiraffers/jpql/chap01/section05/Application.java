package com.ohgiraffers.jpql.chap01.section05;

import com.ohgiraffers.jpql.chap01.section05.dto.CourseDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

/*
* DTO
* - new 키워드 : 쿼리 결과를 DTO 객체로 직접 매핑
* - 객체 중심 : 필요한 속성만 선택해 메모리 효율성 증가
*
* 표현식
* SELECT [new 패키지경로.DTO()] FROM 엔티티
* */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();

        // dto의 생성자를 직접 호출함
        String jpql = "SELECT NEW com.ohgiraffers.jpql.chap01.section05.dto.CourseDTO(c.courseId, c.title, COUNT(1))" +
                " FROM Course c JOIN c.lessons l GROUP BY c.courseId, c.title" +
                " HAVING COUNT(1) > :cnt";

        TypedQuery<CourseDTO> query = em.createQuery(jpql, CourseDTO.class);
        query.setParameter("cnt", 1);

        List<CourseDTO> result = query.getResultList();
        result.forEach(System.out::println);
    }
}
