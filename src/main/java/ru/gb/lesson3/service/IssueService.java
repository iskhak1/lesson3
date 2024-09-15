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
        List<Issue> list = issueRepository.findAll().stream().toList();
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
        return issueRepository.findById(id).get();
    }

    public Book getBookById(Long id){
       return bookRepository.findById(id).get();
    }

    public boolean deleteBookById(Long id){
        return bookRepository.findAll().stream().toList().remove(id);
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public Reader getReaderById(Long id){
        return readerRepository.findById(id).get();
    }

    public boolean deleteReaderById(Long id){
        return readerRepository.findAll().stream().toList().remove(id);
    }

    public void createReader(Reader reader){
        readerRepository.save(reader);
    }


    public List<Book> getAllBook() {
        return bookRepository.findAll().stream().toList();
    }

    public List<Reader> getAllReader() {
        return readerRepository.findAll().stream().toList();
    }
}
