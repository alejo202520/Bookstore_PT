package com.example.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "generes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Genre {

    @Id
    private Long id;

    private String name;
}
