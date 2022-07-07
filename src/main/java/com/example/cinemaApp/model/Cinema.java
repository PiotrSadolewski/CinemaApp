package com.example.cinemaApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cinema")
    private List<CinemaHall> cinemaHalls = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "adres_id")
    private Adres adres;

    public void addCinemaHall(CinemaHall cinemaHall){
        cinemaHalls.add(cinemaHall);
    }

    public void removeCinemaHall(CinemaHall cinemaHall){
        cinemaHalls.remove(cinemaHall);
    }

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }
}
