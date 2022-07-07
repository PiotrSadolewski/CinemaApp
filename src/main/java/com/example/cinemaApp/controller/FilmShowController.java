package com.example.cinemaApp.controller;

import com.example.cinemaApp.Service.CinemaHallService;
import com.example.cinemaApp.Service.FIlmShowService;
import com.example.cinemaApp.Service.MovieService;
import com.example.cinemaApp.model.CinemaHall;
import com.example.cinemaApp.model.FilmShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilmShowController {
    private final FIlmShowService fIlmShowService;
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    @Autowired
    public FilmShowController(FIlmShowService fIlmShowService, CinemaHallService cinemaHallService, MovieService movieService) {
        this.fIlmShowService = fIlmShowService;
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    @GetMapping("/filmshow/{hallId}")
    public String addFilmShow(Model model){
        model.addAttribute("movies", movieService.getAllMovies());
        return "filmShowForm";
    }

    @PostMapping("/filmshow/{hallId}")
    public String saveFilmShow(FilmShow filmShow,@PathVariable("hallId") long hallId){
        CinemaHall cinemaHall = cinemaHallService.getCinemaHallByID(hallId);
        cinemaHall.addFilmShow(filmShow);
        filmShow.setCinemaHall(cinemaHall);
        fIlmShowService.saveFilmShow(filmShow);
        return "redirect:/hall/showFilmShow/{hallId}";
    }
}
