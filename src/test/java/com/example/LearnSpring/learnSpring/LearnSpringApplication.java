package com.example.LearnSpring.learnSpring;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.awt.*;

@SpringBootApplication
public class LearnSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LearnSpringApplication.class, args);

    }

}