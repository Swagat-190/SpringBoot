package com.example.LearnSpring.learnSpring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data

public class exceptionResponseDto {
    private String apiPath;
    private HttpStatus httpStatus;
    private String error;
    private LocalDateTime localDateTime;

    public exceptionResponseDto(String apiPath, HttpStatus httpStatus, String error, LocalDateTime localDateTime) {
        this.apiPath = apiPath;
        this.httpStatus = httpStatus;
        this.error = error;
        this.localDateTime = localDateTime;
    }
}
