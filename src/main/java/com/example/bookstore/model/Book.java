package com.example.bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String summary;
    private Double price;
    private String state;
    private String image;

    @ManyToOne
    @JoinColumn(name = "gen_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User user;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
