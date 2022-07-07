package com.example.cinemaApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

enum MovieType{
    Horror,
    Thriller,
    Adventure,
    Comedy,
    Romans,
    Action
}

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String duration;
    private int minClientAge;
    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @OneToMany(mappedBy = "movie")
    private List<FilmShow> FilmShows = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "filmdirector_id", referencedColumnName = "Id")
    private FilmDirector director;
}