package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.Country;
import com.example.library.model.dto.AuthorDto;
import com.example.library.model.exception.DefaultException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.CountryRepository;
import com.example.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> addAuthor(String name, String surname, Country country) {
        return Optional.of(this.authorRepository.save(new Author(name, surname, country)));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        return Optional.of(this.authorRepository.save(new Author(authorDto.getName(), authorDto.getSurname(), authorDto.getCountry())));
    }
}
