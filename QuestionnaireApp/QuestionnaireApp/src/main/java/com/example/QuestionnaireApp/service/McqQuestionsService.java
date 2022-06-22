package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.MCQQuestionDTO;
import com.example.QuestionnaireApp.model.MCQQuestion;

import java.util.List;

public interface McqQuestionsService {
    void saveQuestions(MCQQuestion data);
    List<MCQQuestionDTO> getQuestionByQuestionnaireId(Long id);
    MCQQuestion updateQuestion(Long id, MCQQuestion MCQQuestion);
    String deleteQuestion(Long id);
}
