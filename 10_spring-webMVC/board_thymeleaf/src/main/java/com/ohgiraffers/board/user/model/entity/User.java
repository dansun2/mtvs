package com.ohgiraffers.board.user.model.entity;

import com.ohgiraffers.board.common.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_number")
    private Integer userPk;

    @Column(name = "user_id", nullable = false, unique = true, length = 20)
    private String userId;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private Status userStatus;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public User() {
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.userPassword = builder.userPassword;
        this.userRole = builder.userRole;
        this.userStatus = builder.userStatus;
        this.createdAt = builder.createdAt;
    }

    public static class Builder {
        private String userId;
        private String userPassword;
        private UserRole userRole;
        private Status userStatus;
        private LocalDateTime createdAt;

        public Builder() {}

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder userPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public Builder userRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public Builder userStatus(Status userStatus) {
            this.userStatus = userStatus;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public Integer getUserPk() {
        return userPk;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public Status getUserStatus() {
        return userStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userPk=" + userPk +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                ", userStatus=" + userStatus +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
