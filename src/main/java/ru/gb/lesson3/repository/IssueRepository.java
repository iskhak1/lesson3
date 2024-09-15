package ru.gb.lesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson3.model.Issue;

import java.util.List;
import java.util.Objects;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {

}
