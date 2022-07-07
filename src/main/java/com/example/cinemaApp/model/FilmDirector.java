package com.example.cinemaApp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class FilmDirector extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String achievment;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies = new ArrayList<>();
}
