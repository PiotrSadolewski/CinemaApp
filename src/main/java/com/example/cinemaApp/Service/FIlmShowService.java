package com.example.cinemaApp.Service;

import com.example.cinemaApp.model.FilmShow;

import java.util.List;

public interface FIlmShowService {
    FilmShow saveFilmShow(FilmShow filmShow);
    FilmShow getFilmShowById(Long id);
    void deleteFilmShow(Long id);
    List<FilmShow> getAllFilmShows();
}
