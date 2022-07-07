package com.example.cinemaApp.Service;

import com.example.cinemaApp.model.Cinema;

import java.util.List;

public interface CinemaService {
    Cinema saveCinema(Cinema cinema);
    List<Cinema> getAllCinemas();
    Cinema getCinemaByID(Long id);
    Cinema updateCinema(Cinema cinema, Long id);
    void deleteCinema(Long id);
}
