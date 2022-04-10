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

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);

        Author author1 = new Author("Miguel", "De Cervantes", country1);
        Author author2 = new Author("Edgar", "Allan poe", country3);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);

        Book book1 = new Book("The Raven", Category.CLASSICS, author2, 10);
        Book book2 = new Book("Don Quixote", Category.NOVEL, author1, 15);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
    }
}
