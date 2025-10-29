package com.example.bookstore.utils;

import com.example.bookstore.security.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class TokenGenerator {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TokenGenerator.class, args);

        JwtUtil jwtUtil = context.getBean(JwtUtil.class);

        UserDetails userJuan = User.builder().username("juan").password("password").roles("USER").build();
        UserDetails userMaria = User.builder().username("maria").password("password").roles("USER").build();
        UserDetails userCarlos = User.builder().username("carlos").password("password").roles("USER").build();

        System.out.println("juan -> " + jwtUtil.generateToken(userJuan));
        System.out.println("maria -> " + jwtUtil.generateToken(userMaria));
        System.out.println("carlos -> " + jwtUtil.generateToken(userCarlos));

        System.exit(0);
    }
}
