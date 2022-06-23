package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.FileQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileQuestionsRepository extends JpaRepository<FileQuestions, Integer> {
}
