package com.example.cinemaApp.repository;

import com.example.cinemaApp.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {}
