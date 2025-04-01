package com.ohgiraffers.chap02.model;

import jakarta.persistence.*;
/*
* 객체지향(OOP)와 RDB의 패러다임 차이 : 네이밍 문제와 JPA의 해결
*
* 이 "Role" 클래스는 객체지향 프로그래밍의 관점에서 하나의 권한(role)을 나타낸다.
* 객체지향에서는 일반적으로 단수형을 사용하여 개별 객체를 표현한다.
* 따라서 클래스 이름을 Role을 사용하는 것이 자연스럽다.
*
* JPA가 이 문제를 해결하는 방법
* JPA는 객체지향과 RDB 간의 패러다임 차이를 해결하기 위해 매핑 매커니즘을 제공한다.
* - @Entity 어노테이션을 사용하여 Role 클래스를 JPA 엔터티로 정의한다.
* - @Table(name="roles") 어노테이션을 사용해 객체지향의 Role 클래스와 RDB의 Roles 테이블을 명시적으로 매핑한다.
*   이를 통해 이름 관례의 차이(단수형 vs 복수형)을 조정한다.
* - @Column(name="role_id")를 사용해 필드와 테이블 컬럼간의 차이를 매핑한다.
* */
@Entity
@Table(name = "roles") // db의 어떤 테이블과 연결되는지
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id") // 해당 필드가 어떤 컬럼이랑 연결되는지
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    /*
    * 기본생성자가 필요한 이유
    * JPA는 엔터티 객체를 생성하고 관리하는 과정에서 "기본 생성자"를 반드시 요구한다.
    * - JPA의 동작 방식 : JPA는 데이터베이스에서 조회한 데이터를 객체로 매핑할 때, 먼저 기본생성자를 호출해서 객체를 생성한 후,
    *   리플렉션을 사용해 필드 값을 주입한다.
    * - 기본생성자 없을 시 문제 : 만약 기본생성자가 없다면, JPA는 객체를 생성할 수 없어 "InstantiationException"이 발생하게 된다.
    * */
    // 항상 기본생성자를 갖고 있어야 함. jpa에서 엔터티를 생성할 때 기본생성자를 통해 생성함 -> 언제든지 db에 입력될 수 있는 상태
    public Role() {}

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
