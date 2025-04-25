package com.ohgiraffers.board.user.model.dto;

public class LoginUserDTO {
    private Integer userPk;
    private String userId;
    private String userPassword;
    private String userRole;

    public LoginUserDTO() {
    }

    public LoginUserDTO(Integer userPk, String userId, String userPassword, String userRole) {
        this.userPk = userPk;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public Integer getUserPk() {
        return userPk;
    }

    public void setUserPk(Integer userPk) {
        this.userPk = userPk;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "userPk=" + userPk +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
