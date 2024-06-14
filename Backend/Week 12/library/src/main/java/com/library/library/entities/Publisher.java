package com.library.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "publisher_establishment")
    private int establishment;

    @Column(name = "publisher_address")
    private String address;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
