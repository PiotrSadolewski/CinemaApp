package com.example.cinemaApp.controller;

import com.example.cinemaApp.Service.CinemaHallService;
import com.example.cinemaApp.Service.CinemaService;
import com.example.cinemaApp.model.Cinema;
import com.example.cinemaApp.model.CinemaHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CinemaHallController {

    private final CinemaHallService cinemaHallService;
    private final CinemaService cinemaService;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService, CinemaService cinemaService) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaService = cinemaService;
    }

    @GetMapping("/hall/list")
    public String showHalls(Model model) {
        model.addAttribute("halls", cinemaHallService.getAllCinemaHalls());
        return "hallList";
    }

    @GetMapping("/hall/form/{cinemaId}")
    public String addHall(){
        return "hallForm";
    }

    @PostMapping("/hall/form/{cinemaId}")
    public String saveHallCinema(CinemaHall cinemaHall, @PathVariable("cinemaId") Long cinemaId){
        Cinema cinema = cinemaService.getCinemaByID(cinemaId);
        cinema.addCinemaHall(cinemaHall);
        cinemaHall.setCinema(cinema);
        cinemaHallService.saveCinemaHall(cinemaHall);
        return "redirect:/cinema/showHall/{cinemaId}";
    }

    @GetMapping("/hall/showFilmShow/{hallId}")
    public String showHallFIlmShow(@PathVariable("hallId") long hallId, Model model){
        model.addAttribute("cinemaHall",cinemaHallService.getCinemaHallByID(hallId));
        return "hallShowFilmShows";
    }

}