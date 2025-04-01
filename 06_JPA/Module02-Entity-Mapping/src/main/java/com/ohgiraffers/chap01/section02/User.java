package com.ohgiraffers.chap01.section02;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String userName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    /*
    * 날짜 및 시간 타입 매핑 (날짜는 범위연산을 한다)
    * > LocalDate : 날짜만 저장(yyyy-mm-dd)
    * > LocalDateTime : 날짜 + 시간(yyyy-mm-dd hh:mm:ss)
    * */
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /*
    * @Enumerated - Enum 타입 필드 매핑
    *
    * 자바의 Enum을 테이블에 저장하는 방법
    *   - ORDINAL : ENUM 순서(int) 저장 -> 위험
    *   - STRING : ENUM 이름을 그대로 저장 -> 권장
    * */
    @Enumerated(EnumType.STRING)
    @Column(name = "role_id", nullable = false)
    private Role role;

    public User() {
    }

    public User(Long id, String userName, String email, String passwordHash, LocalDate birthDate, LocalDateTime createdAt, Role role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", birthDate=" + birthDate +
                ", createdAt=" + createdAt +
                ", role=" + role +
                '}';
    }
}
