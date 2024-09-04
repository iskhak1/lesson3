package ru.gb.lesson3.api;

import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson3.model.Issue;
import ru.gb.lesson3.service.IssueService;


@Log4j2
@RestController
@RequestMapping("/issue")
public class IssuerController {

    @Autowired
    private IssueService service;

    @PostMapping
    public ResponseEntity<Issue> issueBook1(@RequestBody IssueRequest issueRequest) {
        log.info("Получен запрос на выдачу: readerId={}, bookId={}", issueRequest.getReaderId(), issueRequest.getBookId());
        final Issue issue;

        if (service.check(issueRequest.getReaderId()) != true) {
            try {
                issue = service.issue(issueRequest);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }



    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Issue> getIssueById(@PathVariable("id") Long id){
        final Issue issue;
            issue = service.getIssueById(id);
            if(issue!=null){
                return new ResponseEntity<>(issue,HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }





}
