package com.example.cinemaApp.controller;

import com.example.cinemaApp.Service.AdresService;
import com.example.cinemaApp.Service.CinemaHallService;
import com.example.cinemaApp.Service.CinemaService;
import com.example.cinemaApp.model.Adres;
import com.example.cinemaApp.model.Cinema;
import com.example.cinemaApp.model.dto.CinemaAdres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CinemaController {


    private final CinemaService cinemaService;
    private final CinemaHallService cinemaHallService;
    private final AdresService adresService;

    @Autowired
    public CinemaController(CinemaService cinemaService, CinemaHallService cinemaHallService, AdresService adresService) {
        this.cinemaService = cinemaService;
        this.cinemaHallService = cinemaHallService;
        this.adresService = adresService;
    }

    @GetMapping("/cinema")
    public String home(){
        return "cinema";
    }


    @GetMapping("cinema/list")
    public String showCinemas(Model model) {
        model.addAttribute("cinemas", cinemaService.getAllCinemas());
        return "cinemaList";
    }

    @PostMapping( "/cinema/add")
    public String saveCinema(CinemaAdres cinemaAdres){
        Cinema cinema = new Cinema();
        cinema.setName(cinemaAdres.getName());
        cinemaService.saveCinema(cinema);
        Adres adres = new Adres();
        adres.setCity(cinemaAdres.getCity());
        adres.setPostalCode(cinemaAdres.getPostalCode());
        adres.setStreetNumber(cinemaAdres.getStreetNumber());
        adresService.saveAdres(adres);
        adres.setCinema(cinema);
        cinema.setAdres(adres);
        cinemaService.saveCinema(cinema);
        adresService.saveAdres(adres);
        return "redirect:/cinema/list";
    }

    @GetMapping("/cinema/form")
    public String cinema(){
        return "cinemaForm";
    }

    @GetMapping("/cinema/showHall/{cinemaId}")
    public String showCinemaCinemaHall(@PathVariable("cinemaId") long cinemaId, Model model){
        model.addAttribute("cinema", cinemaService.getCinemaByID(cinemaId));
        return "cinemaShowHalls";
    }
}
