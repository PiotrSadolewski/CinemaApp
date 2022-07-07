package com.example.cinemaApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class FilmShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filmStart;
    private String filmEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinemahall_id", referencedColumnName = "Id")
    private CinemaHall cinemaHall;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", referencedColumnName = "Id")
    private Movie movie;
}
