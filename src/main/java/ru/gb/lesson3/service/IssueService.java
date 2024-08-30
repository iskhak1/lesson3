package ru.gb.lesson3.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.gb.lesson3.api.IssueRequest;
import ru.gb.lesson3.model.Book;
import ru.gb.lesson3.model.Issue;
import ru.gb.lesson3.model.Reader;
import ru.gb.lesson3.repository.BookRepository;
import ru.gb.lesson3.repository.IssueRepository;
import ru.gb.lesson3.repository.ReaderRepository;
import java.util.List;
import java.util.Objects;


@Log4j2
@Service
@RequiredArgsConstructor
public class  IssueService {

    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    public Issue issue(IssueRequest request){
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Boolean check(Long readerId) throws NullPointerException{
        List<Issue> list = issueRepository.getAllIssue().stream().toList();
        Issue issue;
     if(list!=null){
       issue = list.stream()
               .filter(it-> Objects.equals(it.getReaderId(),readerId))
               .findFirst()
               .orElse(null);
        if(issue!=null){
            return true;
        }
     }
     return false;
    }



    public Issue getIssueById(Long id){
        return issueRepository.getIssueById(id);
    }

    public Book getBookById(Long id){
       return bookRepository.getBookById(id);
    }

    public boolean deleteBookById(Long id){
        return bookRepository.getBooks().remove(id);
    }

    public void createBook(Book book){
        bookRepository.getBooks().add(book);
    }

    public Reader getReaderById(Long id){
        return readerRepository.getReaderById(id);
    }

    public boolean deleteReaderById(Long id){
        return readerRepository.getReaders().remove(id);
    }

    public void createReader(Reader reader){
        readerRepository.getReaders().add(reader);
    }


}
