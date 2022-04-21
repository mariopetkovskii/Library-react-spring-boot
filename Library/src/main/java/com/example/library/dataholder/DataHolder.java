package com.example.library.dataholder;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.model.Country;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CountryRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init(){
        Country country1 = new Country("Spain", "Europe");
        Country country2 = new Country("Macedonia", "Europe");
        Country country3 = new Country("USA", "North America");
        Country country4 = new Country("Bosnia", "Europe");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);
        this.countryRepository.save(country4);

        Author author1 = new Author("Miguel", "De Cervantes", country1);
        Author author2 = new Author("Edgar", "Allan poe", country3);
        Author author3 = new Author("Mario", "Petkovski", country2);
        Author author4 = new Author("Ivo", "Andric", country4);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);
        this.authorRepository.save(author4);

        Book book1 = new Book("The Raven", Category.CLASSICS, author2, 10);
        Book book2 = new Book("Don Quixote", Category.NOVEL, author1, 15);
        Book book3 = new Book("Web Programming", Category.CLASSICS, author3, 500);
        Book book4 = new Book("La Galatea", Category.CLASSICS, author1, 123);
        Book book5 = new Book("The damned yard", Category.CLASSICS, author4, 12);
        Book book6 = new Book("The Tell-Tale Heart", Category.CLASSICS, author2, 42);
        Book book7 = new Book("The Black Cat", Category.CLASSICS, author2, 0);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book4);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);
        this.bookRepository.save(book7);
    }
}
