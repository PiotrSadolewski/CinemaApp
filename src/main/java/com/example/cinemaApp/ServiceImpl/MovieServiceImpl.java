package com.example.cinemaApp.ServiceImpl;

import com.example.cinemaApp.Service.MovieService;
import com.example.cinemaApp.model.Movie;
import com.example.cinemaApp.repository.Movierepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final Movierepository movierepository;

    @Autowired
    public MovieServiceImpl(Movierepository movierepository) {
        this.movierepository = movierepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movierepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movierepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Cinema with id: " + id));
    }
}
