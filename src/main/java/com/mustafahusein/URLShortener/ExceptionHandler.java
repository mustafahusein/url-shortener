package com.mustafahusein.URLShortener;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.net.MalformedURLException;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MalformedURLException.class)
    public ResponseEntity<String> handleMalformedURL(MalformedURLException exception) {
        return new ResponseEntity<>("Not a valid url", HttpStatus.NOT_ACCEPTABLE);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException exception)   {
        return new ResponseEntity<>("URL not found", HttpStatus.NOT_FOUND);
    }
}
