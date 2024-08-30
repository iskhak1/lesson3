package ru.gb.lesson3.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue { //выдача книг
    public static long sequence = 1L;

    private final long readerId;
    private final long id;
    private final long bookId;
    private LocalDateTime timestamp;
    public Issue(long bookId, long readerId){
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now();

    }

}
