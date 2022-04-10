package com.example.library.model.dto;

import com.example.library.model.Country;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class AuthorDto {

    private String name;

    private String surname;

    private Country country;

    public AuthorDto(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
