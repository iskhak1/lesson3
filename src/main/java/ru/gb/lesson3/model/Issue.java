package ru.gb.lesson3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "issues")
public class Issue { //выдача книг
    public static long sequence = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long readerId;
    private long bookId;
    private LocalDateTime timestamp;
    public Issue(long bookId, long readerId){
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now();

    }

    public Issue() {
    }
}
