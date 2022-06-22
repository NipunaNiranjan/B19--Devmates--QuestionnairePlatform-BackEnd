package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.QuestionnaireDTO;
import com.example.QuestionnaireApp.model.Questionnaire;

import java.util.List;

public interface QuestionnaireService {
     Questionnaire saveQuestionnaire(Questionnaire data);
     List<Questionnaire> getQuestionnaire();
     String deleteQuestionnaire(final long id);
     List<QuestionnaireDTO> getQuestionnaires(Long classId);
}