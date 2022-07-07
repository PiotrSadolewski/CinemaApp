package com.example.cinemaApp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String postalCode;
    private String streetNumber;
    private String city;

    @OneToOne(mappedBy = "adres")
    private Cinema cinema;
}

