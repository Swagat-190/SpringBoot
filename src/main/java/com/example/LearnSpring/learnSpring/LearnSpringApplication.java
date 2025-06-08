package com.example.LearnSpring.learnSpring;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.awt.*;
@OpenAPIDefinition(
		info = @Info(
				title = "Production Api Documenttion",
				description = "Production Api",

				version ="v1",
				contact = @Contact(
						name = "Swagat Mohapatra",
						email = "swagatm190@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "servoce point",
				url =  "locsl"
		)


)

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
		 SpringApplication.run(LearnSpringApplication.class, args);
	}

}

