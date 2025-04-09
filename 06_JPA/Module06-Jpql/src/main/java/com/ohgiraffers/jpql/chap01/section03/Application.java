package com.ohgiraffers.jpql.chap01.section03;

import com.ohgiraffers.jpql.chap01.model.Course;
import com.ohgiraffers.jpql.chap01.model.Lesson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT c FROM Course c WHERE c.price >= 300";
//        List<Course> courses = em.createQuery(jpql, Course.class).getResultList();
        
        // TypedQuery를 쓰는 이유는 컴파일 시점에 오류가 발생하여 타입의 불일치 뭊베를 미리 확인할 수 있음
        String typedJpql = "SELECT c FROM Course c WHERE c.price >= 300";
//        TypedQuery<Lesson> query = em.createQuery(typedJpql, Lesson.class).getResultList();

        TypedQuery<Course> coursesType = em.createQuery(typedJpql, Course.class);
        coursesType.getResultList().forEach(course -> System.out.println(course.getTitle() + " - " + course.getPrice()));
    }
}
