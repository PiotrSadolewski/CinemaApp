package com.example.cinemaApp.ServiceImpl;

import com.example.cinemaApp.Service.CinemaService;
import com.example.cinemaApp.model.Cinema;
import com.example.cinemaApp.repository.CinemaHallRepository;
import com.example.cinemaApp.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository, CinemaHallRepository cinemaHallRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getCinemaByID(Long id) {
        return cinemaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Cinema with id: " + id));
    }


    @Override
    @Transactional
    public Cinema updateCinema(Cinema cinema, Long id) {
        Cinema existingCinema = cinemaRepository.findById(id).orElseThrow();
        existingCinema.setName(cinema.getName());
        existingCinema.setCinemaHalls(cinema.getCinemaHalls());

        cinemaRepository.save(existingCinema);
        return existingCinema;
    }

    @Override
    public void deleteCinema(Long id) {
        Cinema deleteCinema = cinemaRepository.findById(id).orElseThrow();
        cinemaRepository.delete(deleteCinema);
    }
}
