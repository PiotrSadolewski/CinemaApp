package com.example.cinemaApp.model;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int seats;
    private int number;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id", referencedColumnName = "Id")
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHall")
    private List<FilmShow> FilmShows = new ArrayList<>();

    public void addFilmShow(FilmShow filmShow){
        FilmShows.add(filmShow);
    }
}
