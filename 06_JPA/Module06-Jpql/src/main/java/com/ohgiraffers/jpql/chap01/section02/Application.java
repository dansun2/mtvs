package com.ohgiraffers.jpql.chap01.section02;

import com.ohgiraffers.jpql.chap01.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

/*
* JPQL의 기본 문법
* - 객체 중심 : 테이블이 아닌 엔티티와 속성명으로 쿼리 작성
* - SQL과 유사 : SELECT, FROM, WHERE 등의 키워드 사용
* */
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT c FROM Course c WHERE c.price >= 300";
        List<Course> courses = em.createQuery(jpql, Course.class).getResultList();
        courses.forEach(course -> System.out.println(course.getTitle() + " - " + course.getPrice()));

        String joinJpql = "SELECT c FROM Course c JOIN c.lessons l WHERE c.price >= 300";

        courses = em.createQuery(joinJpql, Course.class).getResultList();
        for (Course course : courses) {
            System.out.println(course.getTitle() + " - " + course.getPrice());
            course.getLessons().forEach(System.out::println);
            System.out.println();
        }
        em.close();
        emf.close();
    }
}
