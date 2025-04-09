package com.ohgiraffers.valueobject.chap02.section01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            Product product = new Product("멋쟁이 티셔츠");
            AvailableSize sizeS = new AvailableSize("S", 10);
            AvailableSize sizeM = new AvailableSize("M", 20);
            AvailableSize sizeL = new AvailableSize("L", 15);

            product.addAvailableSize(sizeS);
            product.addAvailableSize(sizeM);
            product.addAvailableSize(sizeL);

            em.persist(product);


            /*
             * 문제점 1: 불필요한 엔티티 관리로 인한 오버헤드
             * - AvailableSize는 Product에 종속적인 데이터로, 독립적인 생명주기를 가질 필요가 없다.
             * - 하지만 @Entity로 정의되어 JPA가 이를 독립적으로 엔티티로 관리하게 된다.
             * - 단순한 값 변경(재고 감소)에도 JPA의 변경 추적(Dirty Checking)이 발생하여 불필요한 오버헤드가 초래된다.
             * - 값 JPA에서 엔티티의 변화는 계속 추적하게 된다. 그러나 값 객체의 경우 변화가 발생하면 삭제 후 새롭게 등록하여 추적하지 않는다.
             * */
            product.decreaseStock("M", 5);
            System.out.println("티셔츠 M 사이즈 재고 감소 후 : " + product.getAvailableSizes());


            /*
             * 문제점 2: 동등성 비교 어려움
             * - AvailableSize가 엔티티로 관리되므로, JPA는 참조(메모리) 기반으로 객체를 비교,
             * - 동일한 라벨("M")을 가진 새로운 AvailableSize 객체를 생성하더라도,
             *   컬렉션에서 이를 동일한 객체로 인식하지 않는다.
             * - 이는 JPA에서 엔티티를 식별하는 기준은 ID가 되기 때문에 값만으로 비교하지 않는다.
             * */
            AvailableSize searchM = new AvailableSize("M", 0);
            boolean containsM = product.getAvailableSizes().contains(searchM);
            System.out.println("티셔츠에 M 사이즈가 포함되어 있는가 (참조비교) " + containsM);


            /*
             * 문제점 3: 컬렉션 조작의 번거로움
             * - M 사이즈를 제거하면, 컬렉션 내의 정확한 AvailableSize 인스턴스를 알아야 한다.
             * - 값 객체로 설계하면 단순히 라벨(M)을 기준으로 제거 가능하다.
             * - 또한 양반향 연관관계를 관리해야 하므로 removeVailableSize 메서드에서
             *   AvailableSize의 product 필드를 null로 설정하는 추가 작업이 필요하다.
             * */

            // 정확한 인스턴스 제공이 되어야함
            product.removeAvailableSize(searchM);
            System.out.println("티셔츠에서 검색으로 M사이즈 제거 후 사이즈 목록 : " + product.getAvailableSizes());

            // 같은 인스턴스 제거 요청
            product.removeAvailableSize(sizeM);
            System.out.println("티셔츠에서 등록된 엔티티로 제거 후 사이즈 목록 : " + product.getAvailableSizes());

            AvailableSize newSizeL = new AvailableSize("L", 10);
            product.addAvailableSize(newSizeL);
            System.out.println("티셔츠에 사이즈 추가 후 목록 : " + product.getAvailableSizes());

            /*
             * 문제점 4: 양방향 연관관계 관리의 복잡성
             * - @onetoMany와 @ManyToOne으로 양방향 연관관계를 설정해야 하며,
             *   addAvailableSize와 removeAvailableSize 메서드에서 연관관계를 일관되게 유지해야 한다.
             * - 이는 코드 복잡성을 증가시키며 실수로 연관관계가 끊어질 가능성이 있다.
             * */
            tx.commit();

        } catch (IllegalAccessException e) {
            tx.rollback();
            System.out.println("유효하지 않은 값입니다. : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
