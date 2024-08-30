package ru.gb.lesson3.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson3.model.Reader;
import ru.gb.lesson3.service.IssueService;

@Log4j2
@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private IssueService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Reader> getReaderById(@PathVariable("id") Long id){
        Reader reader = service.getReaderById(id);
        if(reader != null){
            return new ResponseEntity<>(reader,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReaderById(@PathVariable("id") Long id){
        service.deleteReaderById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createReader(@RequestBody Reader reader){
        service.createReader(reader);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
