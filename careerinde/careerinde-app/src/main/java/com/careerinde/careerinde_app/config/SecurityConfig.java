package com.careerinde.careerinde_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/", "/register", "/login").permitAll()

                .requestMatchers("/dashboard").authenticated()

                .anyRequest().authenticated()
            )

            .formLogin(form -> form

                .loginPage("/login")

                .usernameParameter("username")

                .passwordParameter("password")

                .defaultSuccessUrl("/dashboard", true)

                .permitAll()
            )

            .logout(logout -> logout

                .logoutSuccessUrl("/login")
            );

        return http.build();
    }
}