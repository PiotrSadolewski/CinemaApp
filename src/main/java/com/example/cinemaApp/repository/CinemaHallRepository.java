package com.example.cinemaApp.repository;

import com.example.cinemaApp.model.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
}
