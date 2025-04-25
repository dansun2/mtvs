package com.ohgiraffers.board.user.service;

import com.ohgiraffers.board.common.Status;
import com.ohgiraffers.board.user.model.dto.LoginUserDTO;
import com.ohgiraffers.board.user.model.dto.SignupDTO;
import com.ohgiraffers.board.user.model.entity.User;
import com.ohgiraffers.board.user.model.entity.UserRole;
import com.ohgiraffers.board.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Transactional
    public Integer signup(SignupDTO signupDTO) {
        // 아이디 기준으로 사용자가 있는지 조회
        Optional<User> findUser = userRepository.findByUserId(signupDTO.getUserId());

        if (findUser.isPresent()) {
            return null;
        }
        try {
            // 받아온 dto를 entity로 변환
            User user = new User.Builder()
                    .userId(signupDTO.getUserId())
                    .userPassword(encoder.encode(signupDTO.getUserPassword()))
                    .userRole(UserRole.USER)
                    .userStatus(Status.ACTIVE)
                    .createdAt(LocalDateTime.now())
                    .build();
            // db에 저장
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public LoginUserDTO findByUserId(String userId) {
        Optional<User> findUser = userRepository.findByUserId(userId);

        return findUser.map(user -> new LoginUserDTO(
                user.getUserPk(),
                user.getUserId(),
                user.getUserPassword(),
                user.getUserRole().toString()
        )).orElse(null);
    }

    @Override
    public String getUserIdById(Integer userId) {
        return userRepository.findById(userId).get().getUserId();
    }
}
