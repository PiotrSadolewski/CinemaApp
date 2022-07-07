package com.example.cinemaApp.Service;

import com.example.cinemaApp.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
}
