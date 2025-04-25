package com.ohgiraffers.board.post.model.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostDTO {
    private int postId;
    private String postTitle;
    private String postContent;
    private LocalDateTime createdAt;
    private String userId;

    public PostDTO() {
    }

    public PostDTO(int postId, String postTitle, String postContent, LocalDateTime createdAt, String userId) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getFormattedCreatedAt() {
        return this.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", createdAt=" + createdAt +
                ", userId='" + userId + '\'' +
                '}';
    }
}
