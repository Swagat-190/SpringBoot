package com.example.LearnSpring.learnSpring.Exception;

import com.example.LearnSpring.learnSpring.DTO.exceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<exceptionResponseDto> handleCategoryAlradyExist(CategoryAlreadyExistException e, WebRequest webRequest){
        exceptionResponseDto exceptionResponseDto = new exceptionResponseDto(webRequest.getDescription(false),
                HttpStatus.CONFLICT,
                e.getMessage(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDto);
    }
    @ExceptionHandler(categoryNotFoundException.class)
    public ResponseEntity<exceptionResponseDto> handleCategoryNotFound(categoryNotFoundException e,WebRequest webRequest){
        exceptionResponseDto exceptionResponseDto = new exceptionResponseDto(webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDto);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<exceptionResponseDto> handleGlobalException(categoryNotFoundException e,WebRequest webRequest){
        exceptionResponseDto exceptionResponseDto = new exceptionResponseDto(webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDto);
    }
}
