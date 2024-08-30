package ru.gb.lesson3.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.lesson3.model.Book;
import ru.gb.lesson3.model.Reader;

import javax.print.attribute.standard.JobKOctets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    @PostConstruct
    public void generateDat(){
        books.addAll(List.of(
                new Book("Война и мир"),
                new Book("Мертвые души"),
                new Book("чистые души")
        ));
    }

    public Book getBookById(Long id){
        return books.stream().filter(it-> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooks(){
        return books;
    }

}
