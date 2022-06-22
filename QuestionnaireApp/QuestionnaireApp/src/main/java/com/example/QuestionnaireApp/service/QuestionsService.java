package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.SAQuestionDTO;
import com.example.QuestionnaireApp.model.SAQuestion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface QuestionsService {
    void saveQuestions(SAQuestion data);
    List<SAQuestionDTO> getQuestionByQuestionnaireId(Long id);
    Optional<SAQuestion> getQuestion(Long id);
    SAQuestion updateQuestion(Long id, SAQuestion SAQuestion);
    String deleteQuestion(Long id);
}
