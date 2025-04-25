package com.ohgiraffers.board.post.controller;

import com.ohgiraffers.board.auth.model.AuthDetails;
import com.ohgiraffers.board.post.model.dto.PostDTO;
import com.ohgiraffers.board.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.attribute.UserPrincipal;
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

    // 게시글 전체조회
    @GetMapping
    public ModelAndView getAllPosts() {
        List<PostDTO> allPosts = postService.getAllPosts();

        ModelAndView mv = new ModelAndView("posts");
        mv.addObject("posts", allPosts != null ? allPosts : new ArrayList<>()); // 게시글이 있으면 넣어주고 없으면 빈 껍데기 반환
        return mv;
    }

    // 게시글 상세
    @GetMapping("/{postId}")
    public ModelAndView getPostById(@PathVariable Integer postId, ModelAndView mv) {
        PostDTO findPost = postService.getPostById(postId);

        if (findPost == null) {
            mv.addObject("errorMessage", "존재하지 않는 게시물입니다.");
            mv.setViewName("error");
            return mv;
        }

        mv.addObject("post", findPost);
        mv.setViewName("post/detail");
        return mv;
    }

    // 게시글등록화면
    @GetMapping("/create")
    public ModelAndView showCreateForm(ModelAndView mv) {
        mv.addObject("postDTO", new PostDTO());
        mv.setViewName("post/create");
        return mv;
    }
    
    // 게시글 등록
    @PostMapping("/create")
    public String createPost(@Valid @ModelAttribute PostDTO postDTO, ModelAndView mv, RedirectAttributes rdtat) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails principal = (AuthDetails) auth.getPrincipal(); // 유저정보
        Integer userPk = principal.getUserPk(); // pk꺼내서 담아줌

        PostDTO savedPost = postService.createPost(postDTO, userPk);

        if (savedPost == null) {
            rdtat.addFlashAttribute("errorMessage", "게시글 등록에 실패하였습니다. 다시 시도해주세요.");
            return "redirect:/posts/create"; // 등록 실패 시 등록 폼으로
        }
        rdtat.addFlashAttribute("successMessage", "게시글이 성공적으로 등록되었습니다.");
        return "redirect:/posts"; // 성공하면 목록으로 이동
    }

    // 게시글 수정화면
    @GetMapping("/{postId}/update")
    public ModelAndView showEditForm(@PathVariable Integer postId, ModelAndView mv, RedirectAttributes rdtat) {
        PostDTO findPost = postService.getPostById(postId);

        if (findPost == null) {
            rdtat.addFlashAttribute("errorMessage", "수정할 게시글이 없습니다.");
            mv.setViewName("redirect:/posts");
            return mv;
        }

        mv.addObject("post", findPost);
        mv.setViewName("post/update");
        return mv;
    }

    // 게시글 수정
    @PatchMapping("/{postId}/update")
    public String updatePost(@PathVariable Integer postId, @Valid @ModelAttribute PostDTO postDTO, RedirectAttributes rdtat) {
        PostDTO updatedPost = postService.updatePost(postId, postDTO);

        if (updatedPost == null) {
            rdtat.addFlashAttribute("errorMessage", "게시글 수정에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/posts/" + postId + "/edit"; // 다시 수정하도록 리다이렉트함
        }

        return "redirect:/posts/{postId}"; // 게시글 수정하고 나서 게시글 전체조회로
    }

    // 게시글 삭제
    @DeleteMapping("/{postId}/delete")
    public String deletePost(@PathVariable Integer postId, RedirectAttributes rdtat) {
        boolean result = postService.deletePost(postId);

        if (!result) {
            rdtat.addFlashAttribute("errorMessage", "게시글 삭제를 실패했습니다. 다시 시도해주세요.");
            return "redirect:/posts"; // 삭제 실패하면 목록에 에러 표시
        }

        rdtat.addFlashAttribute("successMessage", "게시글이 성공적으로 삭제되었습니다.");
        return "redirect:/posts"; // 삭제 성공 시 목록으로
    }
}
