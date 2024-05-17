package com.exercise.rest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "ktos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "test_id")
        private int id;


        @Column(name = "customer_name")
        private String name;

}
