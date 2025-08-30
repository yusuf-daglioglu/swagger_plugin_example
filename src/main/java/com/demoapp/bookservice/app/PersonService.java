package com.demoapp.bookservice.app;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/person")
@RestController
public class PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @ApiOperation(value = "Returns the detail of given person name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded or (your message)"),
            @ApiResponse(code = 401, message = "The request requires user authentication or (your message)"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden or (your message)"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI or (your message)")}
    )
    @RequestMapping(value = "/detail/{name}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> detail(
    ) {
        logger.info("detail service called");
        return ResponseEntity.ok("PersonService detail service response");
    }

    @CustomAnnotation(tokenType = "jwt")
    @ApiOperation(value = "This method lists all persons", notes = "I am note from swagger default annotation!")
    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> list() {
        logger.info("list service called");
        return ResponseEntity.ok("PersonService list service response");
    }
}