package com.ohgiraffers.board.post.service;

import com.ohgiraffers.board.post.model.dto.PostDTO;
import com.ohgiraffers.board.post.model.entity.Post;
import com.ohgiraffers.board.common.Status;
import com.ohgiraffers.board.post.repository.PostRepository;
import com.ohgiraffers.board.user.service.UserService;
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
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<PostDTO> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        List<PostDTO> postLists = new ArrayList<>();
        String userId = "";

        if (allPosts != null) {
            for (Post post : allPosts) {
                PostDTO postDTO = new PostDTO();
                postDTO.setPostId(post.getPostId());
                postDTO.setPostTitle(post.getPostTitle());
                postDTO.setPostContent(post.getPostContent());
                postDTO.setCreatedAt(post.getPostCreatedAt());
                userId = userService.getUserIdById(post.getUserPk()); // pk 기준으로 가져온 id
                postDTO.setUserId(userId);
                postLists.add(postDTO);
            }
            return postLists;
        }
        return new ArrayList<>(); // 게시글이 하나도 없으면 빈 리스트 반환
    }

    public PostDTO getPostById(Integer postId) {
        Optional<Post> post = postRepository.findById(postId); // 엔티티를 꺼내서 옵셔널로 감싸준거 -> 엔티티
        // 엔티티 값을 담아줄 dto를 만들어줌
        // dto의 제목에 엔티티에서 꺼내온 제목을 담아줌
        // dto의 내용에 엔티티에서 꺼내온 내용을 담아줌
        // dto 반환해줌

        String userId = userService.getUserIdById(post.get().getUserPk());
        return post.map(value -> new PostDTO(
                value.getPostId(), value.getPostTitle(), value.getPostContent(), value.getPostCreatedAt(), userId)
        ).orElse(null);
    }

    @Transactional
    public PostDTO createPost(PostDTO postDTO, Integer userPk) {
        Post post = new Post.Builder()
                .postTitle(postDTO.getPostTitle())
                .postContent(postDTO.getPostContent())
                .postCreatedAt(LocalDateTime.now())
                .postStatus(Status.ACTIVE) // 처음 등록할 땐 무조건 active
                .userPk(userPk) // user의 PK값임
                .build();
        Post savedPost = postRepository.save(post);
        String userId = userService.getUserIdById(savedPost.getUserPk()); // pk값을 기준으로 id가져옴
        return new PostDTO(savedPost.getPostId(), savedPost.getPostTitle(), savedPost.getPostContent(), savedPost.getPostCreatedAt(), userId);
    }

    @Transactional
    public PostDTO updatePost(Integer postId, PostDTO postDTO) {
        Optional<Post> findPost = postRepository.findById(postId); // 일단 게시글이 존재하는지 확인

        if (findPost.isPresent()) { // 존재하면
            findPost.get().setPostTitle(postDTO.getPostTitle());
            findPost.get().setPostContent(postDTO.getPostContent());
            findPost.get().setPostUpdatedAt(LocalDateTime.now());

            Post savedPost = postRepository.save(findPost.get());
            String userId = userService.getUserIdById(savedPost.getUserPk());
            PostDTO updatedPostDTO = new PostDTO(savedPost.getPostId(), savedPost.getPostTitle(), savedPost.getPostContent(), savedPost.getPostUpdatedAt(), userId);

            return updatedPostDTO;
        } else { // 게시글이 없으면
            return null; // 여기 익셉션처리해야됨
        }
    }

    @Transactional
    public boolean deletePost(Integer postId) {
        Optional<Post> findPost = postRepository.findById(postId); // 게시글 있나 확인

        if (findPost.isPresent()) {
            findPost.get().setStatus(Status.DELETED);
            findPost.get().setPostDeletedAt(LocalDateTime.now());

            postRepository.save(findPost.get());
            return true;
        } else {
            return false;
        }
    }

}
