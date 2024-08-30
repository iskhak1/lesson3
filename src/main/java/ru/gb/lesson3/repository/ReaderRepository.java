package ru.gb.lesson3.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.lesson3.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {
    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateDat(){
        readers.addAll(List.of(
                new Reader("Игорь"),
                new Reader("Иван"),
                new Reader("Даша")
        ));
    }

    public Reader getReaderById(Long id){
        return readers.stream().filter(it-> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }

    public List<Reader> getReaders(){
        return readers;
    }

}
