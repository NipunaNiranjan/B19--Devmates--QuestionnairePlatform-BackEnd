package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.MCQQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface McqQuestionRepository extends JpaRepository<MCQQuestion, Long> {
    List<MCQQuestion> findAllById(Long questionnaireID);
}
