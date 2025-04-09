package com.ohgiraffers.valueobject.chap02.section02;

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
            tx.begin();
            Product product = new Product("멋쟁이 티셔츠");

            AvailableSize sizeS = new AvailableSize("S", 5);
            AvailableSize sizeM = new AvailableSize("M", 20);
            AvailableSize sizeL = new AvailableSize("L", 10);

            product.addVailableSize(sizeS);
            product.addVailableSize(sizeM);
            product.addVailableSize(sizeL);

            em.persist(product);
            /*
             * 해결 1: 불필요한 엔티티 관리 제거
             * - @OneToMany 설계에서는 AvailableSize가 @Entity로 관리되어,
             *   단순한 값 변경(재고 감소)에도 JPa 변경 추적이 발생한다.
             * - ElementCollection으로 변경하면 AvailableSize가 값 객체로 관리되므로,
             *   JPA가 이를 독립적인 엔티티로 관리하지 않는다.
             * - 변경 추적은 Product 엔티티에만 적용되어, AvaliableSize는 Product의 일부로 관리된다.
             * */
            product.decreaseStock("M",5);
            System.out.println("티셔츠 M 사이즈 재고 감소 후 :  " + product.getAvailableSizes());

            /*
             * 해결 2 : 동등성 비교의 용이성
             * - @OneToMany 설계에서는 AvailableSzie가 @Entity로 관리가 되어 JPA가 ID를 기준으로 비교한다.
             * - 동일한 라벨("M")을 가진 새로운 객체를 생성하더라도 ID가 다르거나 영속성 컨텍스트에 없으면 동일한 객체로 인식하지 않는다.
             * - @ElementCollection으로 변경하면 AvailableSize가 값 객체로 관리가 되어 equals 메서드를 통해 라벨을 기준으로 값 기반
             *   비교가 가능해진다.
             * */
            AvailableSize searchM = new AvailableSize("M", 0);
            boolean containsM = product.getAvailableSizes().contains(searchM);
            System.out.println("티셔츠의 옵션에 M 사이즈가 포압되어 있는가 :  " + containsM);

            /*
             * 해결 3 : 컬렉션 조작의 간소화
             * - OneToMany 설계에서는 특정 사이즈를 제거하려면 정확한 AvailableSize 인스턴스를 알아야 한다.
             * - ElementCollection으로 변경하면 값 객체의 equals 메서드를 통해 라벨의 기준으로 제거가 가능하다
             * - 예: 라벨이 "M"인 AvailableSize 객체를 새로 생성하여 제거 가능
             * */
            product.removeAvailableSize(new AvailableSize("M", 0));
            System.out.println("티셔츠 M 사이즈 제거 후 사이즈 목록 확인 :  " + product.getAvailableSizes());

            /*
             * 새로운 L 사이즈 추가
             * @OneToMany 설계에서는 동일한 라벨("L")을 가진 데이터가 중복으로 저장된다.
             * @ElementCollection으로 변경하면 중복을 방지하기 위해 추가 로직을 구현할 수 있게 된다.
             * */
            AvailableSize newLabel = new AvailableSize("L", 10);
            boolean alreadyExists = product.getAvailableSizes().stream()
                    .anyMatch(size -> size.getLabel().equals(newLabel.getLabel()));

            if(!alreadyExists){
                product.addVailableSize(newLabel);
                System.out.println("티셔츠에 새로운 L 사이즈 추가 후 사이즈 목록 : " + product.getAvailableSizes());
            }else{
                System.out.println("이미 사이즈에 L이 존재합니다. : " + product.getAvailableSizes());
            }


            /*
             * ✅ 해결 4: 양방향 연관관계 관리 불필요
             * - @OneToMany 설계에서는 양방향 연관관계를 관리해야 하며,
             *   addAvailableSize와 removeAvailableSize 메서드에서 연관관계를 일관되게 유지해야 함.
             * - @ElementCollection으로 변경하면 단방향 관계로 관리되므로,
             *   양방향 연관관계를 설정하거나 해제할 필요가 없음.
             * - 코드가 간결해지고, 연관관계 불일치로 인한 오류 가능성 감소.
             */

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
