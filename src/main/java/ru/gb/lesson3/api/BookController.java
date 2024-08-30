package ru.gb.lesson3.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson3.model.Book;
import ru.gb.lesson3.service.IssueService;

@Log4j2
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IssueService service;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        Book book = service.getBookById(id);
        if(book!=null){
            return new ResponseEntity<>(book, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        service.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Book book){
        service.createBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
