package ru.gb.lesson3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.lesson3.model.Issue;

import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {

    private final List<Issue> issueList;

    public IssueRepository(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public void save(Issue issue){
        issueList.add(issue);
    }
    public Issue getIssueById(Long id){
        return issueList.stream().filter(it-> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }

    public List<Issue> getAllIssue(){
        return issueList;
    }

}
