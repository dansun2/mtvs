package com.ohgiraffers.postcrud.post.service;

import com.ohgiraffers.postcrud.post.model.dto.PostDTO;
import com.ohgiraffers.postcrud.post.model.entity.Post;
import com.ohgiraffers.postcrud.post.model.entity.PostStatus;
import com.ohgiraffers.postcrud.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDTO> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        List<PostDTO> postLists = new ArrayList<>();

        if (allPosts != null) {
            for (Post post : allPosts) {
                PostDTO postDTO = new PostDTO();
                postDTO.setBoardTitle(post.getPostTitle());
                postDTO.setBoardContent(post.getPostContent());
                postLists.add(postDTO);
            }
            return postLists;
        }
        return new ArrayList<>(); // 게시글이 하나도 없으면 빈 리스트 반환
    }

    public PostDTO getPostById(Integer postId) {
        Optional<Post> post = postRepository.findById(postId);

        return post.map(value -> new PostDTO(
                value.getPostTitle(), value.getPostContent())
        ).orElse(null);
    }

    @Transactional
    public PostDTO createPost(PostDTO postDTO) {
        Post post = new Post.Builder().postTitle(postDTO.getBoardTitle()).postContent(postDTO.getBoardContent()).build();
        Post savedPost = postRepository.save(post);

        return new PostDTO(savedPost.getPostTitle(), savedPost.getPostContent());
    }

    @Transactional
    public PostDTO updatePost(Integer postId, PostDTO postDTO) {
        Optional<Post> post = postRepository.findById(postId); // 일단 게시글이 존재하는지 확인

        if (post.isPresent()) { // 존재하면
            post.get().setPostTitle(postDTO.getBoardTitle());
            post.get().setPostContent(postDTO.getBoardContent());

            Post savedPost = postRepository.save(post.get()); // 저장
            PostDTO updatedPostDTO = new PostDTO(savedPost.getPostTitle(), savedPost.getPostContent());

            return updatedPostDTO;
        } else { // 게시글이 없으면
            return null; // 여기 익셉션처리해야됨
        }
    }

    @Transactional
    public boolean deletePost(Integer postId) {
        Optional<Post> post = postRepository.findById(postId); // 게시글 있나 확인

        if (post.isPresent()) {
            post.get().setPostStatus(PostStatus.DELETED);

            Post savedPost = postRepository.save(post.get());
            return true;
        } else {
            return false;
        }
    }

}
