package com.ohgiraffers.securitysession.user.service;

import com.ohgiraffers.securitysession.common.UserRole;
import com.ohgiraffers.securitysession.user.model.dto.LoginUserDTO;
import com.ohgiraffers.securitysession.user.model.dto.SignupDTO;
import com.ohgiraffers.securitysession.user.model.entity.User;
import com.ohgiraffers.securitysession.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder; // PasswordEncoder는 복호화 불가능하지만, 같은값은 다음번에도 똑같은 값으로 암호화가 된다.

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Transactional
    public Integer regist(SignupDTO signupDTO) {
        if (userRepository.existsByUserId(signupDTO.getUserId())) {
            return null;
        }

        try {
            User user = new User();
            user.setUserId(signupDTO.getUserId());
            user.setUserName(signupDTO.getUserName());
            user.setPassword(encoder.encode(signupDTO.getUserPassword()));
            user.setUserRole(UserRole.valueOf(signupDTO.getRole()));

            User savedUser = userRepository.save(user);
            return savedUser.getUserCode();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public LoginUserDTO findByUserName(String userName) {
        Optional<User> user = userRepository.findByUserId(userName);

        return user.map(u -> new LoginUserDTO(
                u.getUserCode(),
                u.getUserId(),
                u.getUserName(),
                u.getPassword(),
                u.getUserRole()
        )).orElse(null);
    }
}
