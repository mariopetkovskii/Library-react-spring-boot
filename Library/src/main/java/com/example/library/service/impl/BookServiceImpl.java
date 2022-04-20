package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.dto.BookDto;
import com.example.library.model.exception.DefaultException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
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
        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new DefaultException("Author does not exist!"));
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new DefaultException("Book does not exist!"));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new DefaultException("Author does not exist!"));
        book.setAuthor(author);
        Category category = Category.valueOf(bookDto.getCategory().toString());
        book.setCategory(category);
        book.setName(bookDto.getName());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new DefaultException("Book does not exist!"));
        Integer availableCopies = book.getAvailableCopies();
        if(availableCopies == 0){
            throw new DefaultException("This book has no more copies");
        }
        availableCopies -= 1;
        book.setAvailableCopies(availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }
}
