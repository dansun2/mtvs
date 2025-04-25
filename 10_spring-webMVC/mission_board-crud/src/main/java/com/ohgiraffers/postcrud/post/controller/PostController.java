package com.ohgiraffers.postcrud.post.controller;

import com.ohgiraffers.postcrud.post.model.dto.PostDTO;
import com.ohgiraffers.postcrud.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
@Validated
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 전체조회
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> allPosts = postService.getAllPosts();

        if (allPosts == null) {
            return ResponseEntity.ok().body(new ArrayList<>()); // 없으면 리스트 껍데기만 반환
        }
        return ResponseEntity.ok().body(allPosts);
    }

    // 상세조회
    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId) {
        PostDTO findPost = postService.getPostById(postId);

        if (findPost == null) {
            System.out.println("게시물이 존재하지 않거나 삭제됨");
            return ResponseEntity.status(500).body(null); // 익셉션 처리로 수정해야되나?
        }

        return ResponseEntity.ok().body(findPost);
    }

    // 등록
    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) { // 유효성검사
        PostDTO savedPost = postService.createPost(postDTO); // sv에서 "등록" 호출하고 결과 담음

        if (savedPost == null) { // 결과가 안담겼으면 (등록안된거)
            return ResponseEntity.status(500).body(null); // 익셉션처리 수정필요?
        }
        
        return ResponseEntity.ok().body(savedPost); // 등록됐으면 결과 리턴해줌
    }

    // 수정
    @PatchMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Integer postId, @RequestBody PostDTO postDTO) {
        PostDTO updatedPost = postService.updatePost(postId, postDTO);

        if (updatedPost == null) {
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok().body(updatedPost);
    }

    // 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
        boolean result = postService.deletePost(postId);

        if (!result) {
            return ResponseEntity.status(500).body(null);
        }

        return ResponseEntity.ok().build();
    }
}
