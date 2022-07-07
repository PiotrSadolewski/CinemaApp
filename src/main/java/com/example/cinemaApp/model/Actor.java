package com.example.cinemaApp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Actor extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
}
