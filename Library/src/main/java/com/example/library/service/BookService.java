package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.Country;
import com.example.library.model.dto.BookDto;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> addBook(String name, Category category, Author author, Integer availableCopies);

    void deleteById(Long id);

    Optional<Book> save(BookDto bookDto);
}
