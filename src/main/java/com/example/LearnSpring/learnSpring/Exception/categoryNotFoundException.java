package com.example.LearnSpring.learnSpring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class categoryNotFoundException extends RuntimeException {
    public categoryNotFoundException(String message){
        super(message);
    }
}
