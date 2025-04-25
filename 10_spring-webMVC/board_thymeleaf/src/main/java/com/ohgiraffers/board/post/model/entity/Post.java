package com.ohgiraffers.board.post.model.entity;

import com.ohgiraffers.board.common.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_title", nullable = false, length = 50)
    private String postTitle;

    @Column(name = "post_content", nullable = false, length = 2000)
    private String postContent;

    @Column(name = "post_created_at")
    private LocalDateTime postCreatedAt;

    @Column(name = "post_updated_at")
    private LocalDateTime postUpdatedAt;

    @Column(name = "post_deleted_at")
    private LocalDateTime postDeletedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private Status status;

    @Column(name = "user_id")
    private Integer userPk;

    public Post() {
    }

    private Post(Builder builder) {
        this.postTitle = builder.postTitle;
        this.postContent = builder.postContent;
        this.postCreatedAt = builder.postCreatedAt;
        this.postUpdatedAt = builder.postUpdatedAt;
        this.postDeletedAt = builder.postDeletedAt;
        this.status = builder.status;
        this.userPk = builder.userPk;
    }

    public static class Builder {
        private Integer postId;
        private String postTitle;
        private String postContent;
        private LocalDateTime postCreatedAt;
        private LocalDateTime postUpdatedAt;
        private LocalDateTime postDeletedAt;
        private Status status;
        private Integer userPk;

        public Builder() {}

        public Builder postId(Integer postId) {
            this.postId = postId;
            return this;
        }

        public Builder postTitle(String postTitle) {
            this.postTitle = postTitle;
            return this;
        }

        public Builder postContent(String postContent) {
            this.postContent = postContent;
            return this;
        }

        public Builder postCreatedAt(LocalDateTime postCreatedAt) {
            this.postCreatedAt = postCreatedAt;
            return this;
        }

        public Builder postUpdatedAt(LocalDateTime postUpdatedAt) {
            this.postUpdatedAt = postUpdatedAt;
            return this;
        }

        public Builder postDeletedAt(LocalDateTime postDeletedAt) {
            this.postDeletedAt = postDeletedAt;
            return this;
        }

        public Builder postStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder userPk(Integer userPk) {
            this.userPk = userPk;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
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

    public LocalDateTime getPostCreatedAt() {
        return postCreatedAt;
    }

    public void setPostCreatedAt(LocalDateTime postCreatedAt) {
        this.postCreatedAt = postCreatedAt;
    }

    public LocalDateTime getPostUpdatedAt() {
        return postUpdatedAt;
    }

    public void setPostUpdatedAt(LocalDateTime postUpdatedAt) {
        this.postUpdatedAt = postUpdatedAt;
    }

    public LocalDateTime getPostDeletedAt() {
        return postDeletedAt;
    }

    public void setPostDeletedAt(LocalDateTime postDeletedAt) {
        this.postDeletedAt = postDeletedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getUserPk() {
        return userPk;
    }

    public void setUserPk(Integer userPk) {
        this.userPk = userPk;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postCreatedAt=" + postCreatedAt +
                ", postUpdatedAt=" + postUpdatedAt +
                ", postDeletedAt=" + postDeletedAt +
                ", postStatus=" + status +
                '}';
    }
}
