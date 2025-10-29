package com.example.bookstore.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Cambia estos nombres y contraseñas si quieres
        String[] users = {"juan", "maria", "carlos"};
        String rawPassword = "1234"; // la contraseña que quieras usar

        for (String user : users) {
            String hash = encoder.encode(rawPassword);
            System.out.println(user + " -> " + hash);
        }
    }
}
