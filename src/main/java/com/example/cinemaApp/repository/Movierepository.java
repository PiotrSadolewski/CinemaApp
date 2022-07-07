package com.example.cinemaApp.repository;

import com.example.cinemaApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Movierepository extends JpaRepository<Movie, Long> {
}
