package com.example.bookstore.controller;

import com.example.bookstore.dto.AuthRequest;
import com.example.bookstore.model.User;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody AuthRequest req) {
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Usuario ya existe");
        }

        User user = new User();
        user.setFullName(req.getUsername()); // o pedir otro campo en DTO
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setState("ACT");

        userRepository.save(user);

        String token = jwtUtil.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        java.util.Collections.emptyList()
                )
        );

        return Map.of("token", token);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest req) {
        var userOpt = userRepository.findByUsername(req.getUsername());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }
        var user = userOpt.get();

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtUtil.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        java.util.Collections.emptyList()
                )
        );

        return Map.of("token", token);
    }
}
