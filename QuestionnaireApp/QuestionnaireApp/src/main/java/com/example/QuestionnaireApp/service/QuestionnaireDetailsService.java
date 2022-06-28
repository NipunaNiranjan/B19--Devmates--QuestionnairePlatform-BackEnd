package com.example.QuestionnaireApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuestionnaireApp.model.QuestionnaireDetails;
import com.example.QuestionnaireApp.repository.QuestionnaireDetailsRepository;

@Service
public class QuestionnaireDetailsService {
    
    @Autowired
    private QuestionnaireDetailsRepository questionnaireRepository;

    /**
     * save questionnaire
     * 
     * @param data
     * @return
     */
    public QuestionnaireDetails saveQuestionnaire(QuestionnaireDetails data) {
        return questionnaireRepository.save(data);
    }

    /**
     * get all the questionnaires
     * 
     * @return
     */
    public List<QuestionnaireDetails> getQuestionnaire() {
        return questionnaireRepository.findAll();
    }

    public List<QuestionnaireDetails> getQuestionnaireById(int id) {
        return questionnaireRepository.getByQuzId(id);
    }

    /**
     * delete questionnaire by id
     * 
     * @param id
     * @return
     */
    public String deleteQuestionnaire(final int id) {
        if (questionnaireRepository.findById(id).isPresent()) {
            questionnaireRepository.deleteById(id);
            return "Delete successfully";
        } else {
            return "Not found";
        }
    }
}
