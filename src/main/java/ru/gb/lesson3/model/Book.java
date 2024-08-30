package ru.gb.lesson3.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Book  {

    public static long sequence = 1L;

    private final String name;
    private final long id;

    public Book(String name){
        this(name, sequence++);
    }
}

