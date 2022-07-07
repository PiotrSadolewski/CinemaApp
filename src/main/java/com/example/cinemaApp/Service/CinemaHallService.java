package com.example.cinemaApp.Service;
import com.example.cinemaApp.model.CinemaHall;

import java.util.List;
public interface CinemaHallService {
    CinemaHall saveCinemaHall(CinemaHall cinemaHall);
    List<CinemaHall> getAllCinemaHalls();
    CinemaHall getCinemaHallByID(Long id);
    CinemaHall updateCinemaHall(CinemaHall cinemaHall, Long id);
    void deleteCinemaHall(Long id);
    List<CinemaHall> getCinemaHallByHallId(long id);
}
