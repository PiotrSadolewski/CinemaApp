package com.example.cinemaApp.repository;

import com.example.cinemaApp.model.FilmShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmShowRepository extends JpaRepository<FilmShow, Long> {
}
