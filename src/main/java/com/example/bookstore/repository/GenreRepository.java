package com.example.bookstore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookstore.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {}
