package com.example.library.model.dto;

import com.example.library.model.Author;
import com.example.library.model.Category;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class BookDto {

    private String name;

    private Category category;

    private Author author;

    private Integer availableCopies;

    public BookDto(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
