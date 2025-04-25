package com.ohgiraffers.board.auth.service;

import com.ohgiraffers.board.auth.model.AuthDetails;
import com.ohgiraffers.board.user.model.dto.LoginUserDTO;
import com.ohgiraffers.board.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AuthService(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    // 로그인 시도한 사용자의 정보를 db에서 꺼내서 인증을 처리할 수 있도록 넘겨줌
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        LoginUserDTO login = userServiceImpl.findByUserId(userId);

        if (Objects.isNull(login)) { // null 이면 fail 핸들러 동작
            throw new UsernameNotFoundException("회원정보가 존재하지 않습니다.");
        }

        return new AuthDetails(login);
    }
}
