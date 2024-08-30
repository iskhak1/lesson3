package ru.gb.lesson3.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@RequiredArgsConstructor
public class Reader {
    public static long sequence = 1L;

    private final String name;
    private final long id;

    public Reader(String name){
        this(name, sequence++);
    }


}
