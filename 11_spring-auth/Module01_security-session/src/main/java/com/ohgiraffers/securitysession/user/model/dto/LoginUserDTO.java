package com.ohgiraffers.securitysession.user.model.dto;

import com.ohgiraffers.securitysession.common.UserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginUserDTO {

    private int userCode;
    private String userId;
    private String userName;
    private String password;
    private UserRole userRole;

    public LoginUserDTO() {
    }

    // 다중권한을 가질 수 있게 List 타입으로 제공
    public List<String> getRole() {
        if (this.userRole.getRole().length() > 0) { // 초기화가 되어있으면
            return Arrays.asList(this.userRole.getRole().split(","));
        }
        return new ArrayList<>();
    }

    public LoginUserDTO(int userCode, String userId, String userName, String password, UserRole userRole) {
        this.userCode = userCode;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "userCode=" + userCode +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
