package com.ohgiraffers.securitysession.user.repository;

import com.ohgiraffers.securitysession.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(String userId);
    boolean existsByUserId(String userId);
}
