package com.demoapp.bookservice.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book")
@RestController
public class BookService {

    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    @RequestMapping(value = "/search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> detail(BookSearchRequest bookSearchRequest) {
        logger.info("search service called");
        return ResponseEntity.ok("BookService search service response");
    }

    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> list() {
        logger.info("list service called");
        return ResponseEntity.ok("BookService list service response");
    }
}