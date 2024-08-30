package ru.gb.lesson3.api;

import lombok.Data;

@Data
public class IssueRequest {
    private long bookId;
    private long readerId;
}
