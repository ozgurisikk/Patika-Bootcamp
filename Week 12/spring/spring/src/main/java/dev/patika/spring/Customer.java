package dev.patika.spring;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@ToString
//@Data ucunu de ekler
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", length = 10)
    private int id;
    @Column(name = "customer_name", nullable = false, length = 20)
    private String name;

    @Column(name = "customer_mail", nullable = false, unique = true)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private Gender gender;
    public enum Gender{
        MALE,
        FEMALE
    }

    public Customer() {
    }


}
