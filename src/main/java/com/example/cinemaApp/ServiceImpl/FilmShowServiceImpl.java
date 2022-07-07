package com.example.cinemaApp.ServiceImpl;

import com.example.cinemaApp.Service.FIlmShowService;
import com.example.cinemaApp.model.FilmShow;
import com.example.cinemaApp.repository.FilmShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmShowServiceImpl implements FIlmShowService {

    private final FilmShowRepository filmShowRepository;

    public FilmShowServiceImpl(FilmShowRepository filmShowRepository) {
        this.filmShowRepository = filmShowRepository;
    }

    @Override
    public FilmShow saveFilmShow(FilmShow filmShow) {
        return filmShowRepository.save(filmShow);
    }

    @Override
    public FilmShow getFilmShowById(Long id) {
        return filmShowRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Cinema with id: " + id));
    }

    @Override
    public void deleteFilmShow(Long id) {
        FilmShow deleteFS = filmShowRepository.findById(id).orElseThrow();
        filmShowRepository.delete(deleteFS);
    }

    @Override
    public List<FilmShow> getAllFilmShows() {
        return filmShowRepository.findAll();
    }
}
