package com.ohgiraffers.chap02.section02;

import com.ohgiraffers.chap02.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-config");
        EntityManager em = emf.createEntityManager();

        /* 생명주기 테스트 메서드 호출 */

        // 비영속 - 해당 엔티티는 단순한 java
        // testNewState(em);

        // 영속 상태 - 해당 엔티티는 영속성 컨텍스트에서 관리가 되는 객체로 값이 DB에 저장된다.
        // testManagedState(em);

        // 준영속 상태 - 준영속 이전 시점의 상태를 저장하고 DB에 반영함
        // testDetachedState(em);

        // 삭제 상태(Removed) 테스트
        // testRemovedState(em);

        // 준영속 상태에서의 Merge 테스트
        testMergeAfterDetached(em);

        em.close();
        emf.close();
    }

    /**
     * 비영속 상태(New) 테스트
     * - 엔티티 객체가 JPA와 연관되지 않은 상태를 확인한다.
     * */
    private static void testNewState(EntityManager em) {
        em.getTransaction().begin();
        Role role = new Role();
        role.setRoleName("비영속 권한");
        System.out.println("비영속 상태 - Role : "+role.getRoleName());

        em.persist(role);

        role.setRoleName("변경된 비영속 권한");
        em.getTransaction().commit(); // 이 시점에 바뀌는거
    }

    /**
     * 영속 상태(Managed) 테스트
     * - 엔티티가 영속성 컨텍스트에 등록되어 JPA가 관리하는 상태를 확인
     * */
    private static void testManagedState(EntityManager em) {
        // 트랜잭션 시작을 의미함
        em.getTransaction().begin();

        Role role = em.find(Role.class, 101);
        role.setRoleName("new 영속");

        /*
         * 영속 상태
         * em.persist(role)를 호출하여 Role 객체가 영속성 컨텍스트에 등록된다.
         * JPA는 이 객체를 1차 캐시에 보관하며, 상태 변활르 추적한다.
         * - 트랜잭션 커밋 시 INSERT 쿼리가 실행되어 데이터베이스에 반영된다.
         * */
        // em.persist(role);
        System.out.println("영속상태 - role "+role);
        em.getTransaction().commit();
    }

    /**
     * 준영속상태 (Detached)
     * - em.persist(role)로 영속 상태가 된 객체를 em.detach(role)로 준영속 상태로 전환한다.
     * - 준영속 상태에서는 영속성 컨텍스트에서 분리되어 더이상 JPA가 변경을 추적하지 않는다.
     * - 그러나 persist로 인해 이미 INSERT 예정 작업이 등록되었기 때문에 트랜잭션 커밋 시 INSERT가 생성된다.
     * - 준영속 상태에서 변경 사항은 반영하지 않는다.
     * */
    private static void testDetachedState(EntityManager em) {
        em.getTransaction().begin();

        Role role = new Role();
        role.setRoleName("준영속 - 수업");

        // INSERT 예정
        em.persist(role); // 영속화

        // 준영속화 진행
        em.detach(role);

        role.setRoleName("변경 준영속 - 수업");
        em.getTransaction().commit();
    }

    /**
     * 삭제 상태(Removed) 테스트
     * - 엔티티를 삭제 상태로 전환하고 데이터베이스에서 삭제되는 과정을 확인
     * */
    private static void testRemovedState(EntityManager em) {
        em.getTransaction().begin();

        /*
         * 삭제 상태(removed)
         * em.persist(role)로 영속 상태가 된 객체를 삭제 상태로 전환한다.
         * 삭제 상태에서는 트랜잭션 커밋 시 delete 쿼리가 실행되어 데이터베이스에서 해당 레코드가 삭제된다.
         * 단, 데이터베이스에 아직 저장되지 않은 객체(persist 후 커밋 전)에 remove를 호출하면
         * INSERT와 DELETE가 모두 실행되지 않을 수 있다.
         * */
        Role role = new Role();
        role.setRoleName("삭제 권한");

        // 영속화 진행
        em.persist(role);

        // 삭제 상태로 전환
        em.remove(role); // insert가 이전에 이미 예약이 되어 있기 때문에 insert 후 delete 한다.
        System.out.println("삭제 상태");
        em.getTransaction().commit();
    }

    /**
     * 준영속 상태에서 Merge 테스트
     * 준영속 상태의 엔티티를 다시 영속 상태로 전환하는 과정을 확인합니다.
     */
    private static void testMergeAfterDetached(EntityManager em) {
        em.getTransaction().begin();

        /*
        * 준영속 상태에서 Merge
        *
        * 준영속 상태의 객체는 영속성 컨텍스트에서 분리되어 JPA가 관리하지 않는다.
        * em.merge(role)를 호출하면 준영속 상태의 객체를 다시 영속 상태로 전환한다.
        * merge는 데이터베이스의 현재 상태와 비교하여 변경 사항을 반영하며,
        * 새로운 영속 상태의 객체를 반환한다(원본 객체와 다를 수 있음).
        * 트랜잭션 커밋 시 변경 사항이 데이터베이스에 반영된다.
        * */
        Role role = new Role();
        role.setRoleName("Merge 테스트 권한");
        em.persist(role); // 영속성 컨텍스트에 들어감
        System.out.println("영속 상태 - Role: " + role);

        // 새로운 트랜잭션 시작
        em.getTransaction().begin();

        // 준영속 상태로 전환
        em.detach(role);
        System.out.println("준영속 상태 - Role: " + role);

        // 준영속 상태에서 변경
        role.setRoleName("Merge로 변경된 권한");

        // Merge를 통해 다시 영속 상태로 전환
        Role mergedRole = em.merge(role);
        System.out.println("Merge 후 영속 상태 - Role: " + mergedRole);
        System.out.println("원본과 동일한 객체인가? " + (role == mergedRole)); // false일 가능성 있음

        em.getTransaction().commit(); // UPDATE 쿼리 실행 (변경된 데이터 반영)
        em.close();
    }
}
