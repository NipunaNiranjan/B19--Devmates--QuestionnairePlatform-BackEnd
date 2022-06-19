package com.example.QuestionnaireApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class QuestionnaireAppApplication {
	public static void main(String[] args) {

		SpringApplication.run(QuestionnaireAppApplication.class, args);

	}
}
