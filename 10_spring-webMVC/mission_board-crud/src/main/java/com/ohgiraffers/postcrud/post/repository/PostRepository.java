package com.ohgiraffers.postcrud.post.repository;

import com.ohgiraffers.postcrud.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
