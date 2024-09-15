package ru.gb.lesson3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "books")
public class Book  {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    public Book() {

    }
}

