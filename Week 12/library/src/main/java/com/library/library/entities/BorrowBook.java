package com.library.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private int id;

    @Column(name = "borrow_name")
    private String name;

    @Column(name = "borrow_mail")
    @Email
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date")
    private LocalDate borrowDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "borrow_book_id", referencedColumnName = "book_id")
    private Book book;
}
