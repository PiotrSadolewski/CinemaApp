package com.example.cinemaApp.ServiceImpl;

import com.example.cinemaApp.Service.CinemaHallService;
import com.example.cinemaApp.model.CinemaHall;
import com.example.cinemaApp.repository.CinemaHallRepository;
import com.example.cinemaApp.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallsRepository, CinemaRepository cinemaRepository) {
        this.cinemaHallRepository = cinemaHallsRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public CinemaHall saveCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAllCinemaHalls() {
        return cinemaHallRepository.findAll();
    }

    @Override
    public CinemaHall getCinemaHallByID(Long id) {
        return cinemaHallRepository.findById(id).orElseThrow(() ->
        new IllegalArgumentException("could not find cinemaHall with id: " + id));
    }

    @Override
    public CinemaHall updateCinemaHall(CinemaHall cinemaHall, Long id) {
        CinemaHall existingCinemaHall = cinemaHallRepository.findById(id).orElseThrow();
        existingCinemaHall.setSeats(cinemaHall.getSeats());
        cinemaHallRepository.save(existingCinemaHall);
        return existingCinemaHall;
    }

    @Override
    public void deleteCinemaHall(Long id) {
        CinemaHall deleteCinemaHall = cinemaHallRepository.findById(id).orElseThrow();
        cinemaHallRepository.delete(deleteCinemaHall);
    }

    @Override
    public List<CinemaHall> getCinemaHallByHallId(long id) {
        return cinemaHallRepository.findAll().stream()
                .filter(t -> t.getCinema().getId().equals(id)).collect(Collectors.toList());
    }
}
