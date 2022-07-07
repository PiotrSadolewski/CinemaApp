package com.example.cinemaApp.ServiceImpl;

import com.example.cinemaApp.Service.AdresService;
import com.example.cinemaApp.model.Adres;
import com.example.cinemaApp.repository.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresServiceImpl implements AdresService {
    private final AdresRepository adresRepository;

    @Autowired
    public AdresServiceImpl(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    @Override
    public Adres saveAdres(Adres adres) {
        return adresRepository.save(adres);
    }

    @Override
    public Adres getAdresById(Long id) {
        return adresRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find cinemaHall with id: " + id));
    }

    @Override
    public void deleteAdres(Long id) {
        Adres deleteAdres = adresRepository.findById(id).orElseThrow();
        adresRepository.delete(deleteAdres);
    }
}
