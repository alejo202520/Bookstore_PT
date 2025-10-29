package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/genres")
    public List<?> listGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/books")
    public List<Book> listBooksByGenre(@RequestParam(required = false) Long genreId) {
        if (genreId == null) return bookRepository.findAll();
        return bookRepository.findByGenreId(genreId);
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updated) {
        Book b = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        b.setName(updated.getName());
        b.setSummary(updated.getSummary());
        b.setPrice(updated.getPrice());
        b.setImage(updated.getImage());

        if (updated.getGenre() != null) b.setGenre(updated.getGenre());

        return bookRepository.save(b);
    }
}
