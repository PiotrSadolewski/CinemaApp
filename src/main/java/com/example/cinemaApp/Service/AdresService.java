package com.example.cinemaApp.Service;

import com.example.cinemaApp.model.Adres;

public interface AdresService {
    Adres saveAdres(Adres adres);
    Adres getAdresById(Long id);
    void deleteAdres(Long id);
}
