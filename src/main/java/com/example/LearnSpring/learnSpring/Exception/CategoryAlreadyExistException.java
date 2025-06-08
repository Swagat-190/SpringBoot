package com.example.LearnSpring.learnSpring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CategoryAlreadyExistException extends RuntimeException{
    public CategoryAlreadyExistException(String messaage){
        super(messaage);
    }
}
