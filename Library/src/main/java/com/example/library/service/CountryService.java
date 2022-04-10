package com.example.library.service;

import com.example.library.model.Country;
import com.example.library.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> addCountry(String name, String continent);

    void deleteById(Long id);

    Optional<Country> save(CountryDto countryDto);

}
