package com.exercise.rest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "onlys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int id;


    @Column(name = "customer_name")
    private String name;
}
