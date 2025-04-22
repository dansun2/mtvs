package com.ohgiraffers.securitysession.config;

import com.ohgiraffers.securitysession.common.UserRole;
import com.ohgiraffers.securitysession.config.handler.AuthFailHandler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AuthFailHandler authFailHandler;

    /*
    * 비밀번호를 인코딩 하기 위한 bean
    * Bcrypt는 비밀번호 해싱에 가장 많이 사용되는 알고리즘 중 하나이다.
    * */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> { // auth는 아무이름이나 상관없음
            auth.requestMatchers("/auth/login", "/user/signup", "/auth/fail", "/").permitAll(); // 이 경로의 요청은 인증을 받지 않아도 매칭시키겠다
            auth.requestMatchers("/admin/*").hasAnyAuthority(UserRole.ADMIN.getRole()); // /auth의 모든 권한은 ADMIN과 매칭되어야함 + 그리고 url을 리스트로 넣을수도 있음
            auth.requestMatchers("/user/*").hasAnyAuthority(UserRole.USER.getRole()); // /user 의 모든 권한은 USER와 매칭되어야함
            auth.anyRequest().authenticated(); // 이외의 모든 요청은 인증 후에만 사용 가능
        }).formLogin( login -> { // formLogin() 은 내가 지정할 로그인 페이지
            login.loginPage("/auth/login"); // 이 페이지는 permitAll이 되어있어야 인증없이 접근가능
            login.usernameParameter("user");
            login.passwordParameter("pass");
            login.defaultSuccessUrl("/", true); // 성공하면 어디로 리다이렉트할건지
            login.failureUrl("/"); // 로그인 실패하면 보낼 url
            login.failureHandler(authFailHandler); // 실패하면 어떻게 핸들링할건지
        }).logout(logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")); // 뭐로 요청이 들어왔을때 로그아웃처리할건지
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true); // 세션유효시간 소멸
            logout.logoutSuccessUrl("/");
        }).sessionManagement(session -> {
            session.maximumSessions(1); // 중복로그인 1개
            session.invalidSessionUrl("/"); // 중복로그인 maximum 이상 시도시 어디로 이동시킬건지
        }).csrf(csrf -> csrf.disable()); // 보안설정은 복잡해서 비활성화

        return http.build();
    }
}
