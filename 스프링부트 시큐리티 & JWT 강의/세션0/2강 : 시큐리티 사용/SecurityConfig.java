package com.cos.security1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터(해당 객체)가 스프링 필터체인에 등록됨
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF 보호 비활성화
        http.csrf().disable()
                .authorizeHttpRequests(authorize -> authorize

                        //아래 3가지 경로는 필터링에 걸림
                        .requestMatchers("/user/**").authenticated() // /user 경로는 인증 필요
                        .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") // /manager 경로는 MANAGER 또는 ADMIN 역할 필요
                        .requestMatchers("/admin/**").hasRole("ADMIN") // /admin 경로는 ADMIN 역할 필요

                        //위 3가지 경로 빼고는 접근 허용
                        .anyRequest().permitAll()
                )
                
                //필터링에 걸리면 로그인 창으로 이동
                //해당 로그인 창을 개발자가 재정의 함
                .formLogin(form -> form
                        .loginPage("/login") // 사용자 정의 로그인 페이지
                );

        return http.build(); // SecurityFilterChain 반환
    }

}
