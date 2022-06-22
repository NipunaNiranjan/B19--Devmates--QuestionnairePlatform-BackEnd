package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.dto.QuestionnaireDTO;
import com.example.QuestionnaireApp.model.Questionnaire;
import com.example.QuestionnaireApp.repository.QuestionnaireRepository;
import com.example.QuestionnaireApp.service.QuestionnaireService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireServiceImpl(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @Override
    public Questionnaire saveQuestionnaire(Questionnaire data){
        return questionnaireRepository.save(data);
    }

    @Override
    public List<Questionnaire> getQuestionnaire(){
        return questionnaireRepository.findAll();
    }

    @Override
    public String deleteQuestionnaire(final long id){
        if(questionnaireRepository.findById(id).isPresent()){
            questionnaireRepository.deleteById(id);
            return "Delete successfully";
        }else{
            return "Not found";
        }
    }

    @Override
    public List<QuestionnaireDTO> getQuestionnaires(Long classId) {
        List<QuestionnaireDTO> questionnaires = new ArrayList<>();
        for(Questionnaire questionnaire: questionnaireRepository.findAllByAClass_ClassId(classId))
            questionnaires.add(
                    QuestionnaireDTO.builder()
                            .id(questionnaire.getId())
                            .name(questionnaire.getName())
                            .description(questionnaire.getDescription())
                            .type(questionnaire.getType())
                            .build()
            );
        return questionnaires;
    }
}
