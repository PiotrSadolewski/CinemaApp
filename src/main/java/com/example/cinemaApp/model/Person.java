package com.example.cinemaApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;
    private String surname;
    private LocalDate dayOfBirth;
}
