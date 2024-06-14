package com.library.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_birthdate")
    private int birthdate;

    @Column(name = "author_nationality")
    private String nationality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
