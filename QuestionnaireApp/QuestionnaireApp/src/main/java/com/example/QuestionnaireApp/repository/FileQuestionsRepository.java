package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.FileQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FileQuestionsRepository extends JpaRepository<FileQuestions, Integer> {
    public ArrayList<FileQuestions> findAllByQuestionnaireId (int id);
}
