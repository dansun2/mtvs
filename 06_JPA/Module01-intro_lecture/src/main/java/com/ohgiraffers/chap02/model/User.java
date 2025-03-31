package com.ohgiraffers.chap02.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
/*
* 객체지향(OOP)과 RDB 패러다임 차이 : DTO 사용 문제와 JPA의 해결
* JPA가 이 문제를 해결하는 방법
* JPA는 객체지향과 RDB 간의 패러다임 차이를 해결하기 위해 매핑 매커니즘을 제공한다.
* - @Entity와 @Table을 사용해 User 클래스를 users 테이블과 매핑한다.
* - @ManyToOne과 @JoinColumn을 사용해 User와 Role 간의 관계를 객체지향적으로 정의한다.
*   이를 통해 User가 Role 객체를 직접 참조하도록 설계할 수 있으며, RDB의 외래키(role_id)를 기반으로 관계를 매핑한다.
* - DTO에서처럼 평면화된 데이터(rolename)를 직접 포함시키는 대신 Role 객체를 참조함으로써 객체지향의 캡슐화와 관계를 유지한다.
* */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 테이블전략이랑 시퀀스전략도 있음
    @Column(name = "user_id")
    private int userId;

    @Column(nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public User() {
    }

    public User(int userId, String userName, String email, String passwordHash, Role role, LocalDateTime createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}';
    }
}
