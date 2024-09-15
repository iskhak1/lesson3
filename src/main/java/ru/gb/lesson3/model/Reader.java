package ru.gb.lesson3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Reader(){}



}
