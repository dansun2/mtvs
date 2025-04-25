package com.ohgiraffers.board.auth.model;

import com.ohgiraffers.board.user.model.dto.LoginUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AuthDetails implements UserDetails {

    private LoginUserDTO loginUser;

    public AuthDetails() {
    }

    public AuthDetails(LoginUserDTO loginUser) {
        this.loginUser = loginUser;
    }

    public Integer getUserPk() {
        return loginUser.getUserPk();
    }

    public LoginUserDTO getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUserDTO loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // 권한 정보를 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        * SimpleGrantedAuthority는 사용자에게 어떤 권한이 있는지 나타내는 객체
        * 그래서 loginDTO에서 로그인한 사용자의 권한값을 가져온다.
        * simpleGrantedAuthority.getAuthority() 하면 USER 또는 ADMIN이 나오게 되는거(현재 코드로 보면)
        * */
        return List.of(new SimpleGrantedAuthority(loginUser.getUserRole()));
    }

    @Override
    public String getPassword() {
        return loginUser.getUserPassword();
    }

    @Override
    public String getUsername() {
        return loginUser.getUserId();
    }
}
