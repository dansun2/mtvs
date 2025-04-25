package com.ohgiraffers.board.user.repository;

import com.ohgiraffers.board.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(String userId); // 아이디 기준으로 조회
}
