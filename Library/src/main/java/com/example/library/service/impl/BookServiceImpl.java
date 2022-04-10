package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.dto.BookDto;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> addBook(String name, Category category, Author author, Integer availableCopies) {
        return Optional.of(this.bookRepository.save(new Book(name, category, author, availableCopies)));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(),bookDto.getCategory(), bookDto.getAuthor(), bookDto.getAvailableCopies())));
    }
}
