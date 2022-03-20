package com.example.QuestionnaireApp;

import com.example.QuestionnaireApp.model.Question;
import com.example.QuestionnaireApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	private final QuestionRepository questionRepository;

	@Autowired
	public AppApplication(QuestionRepository questionRepository){
		this.questionRepository = questionRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) {

		if(questionRepository.findAll().isEmpty()){
			questionRepository.save(new Question("Abstraction","What is abstraction?"));
			questionRepository.save(new Question("Polymorphism","What is Polymorphism?"));
		}
		for(Question question: questionRepository.findAll()){
			System.out.println(question);
		}
	}
}
