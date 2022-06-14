package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.QuestionnaireDTO;
import com.example.QuestionnaireApp.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    /**
     * save questionnaire
     * @param data
     * @return
     */
    public QuestionnaireDTO saveQuestionnaire(QuestionnaireDTO data){
        return questionnaireRepository.save(data);
    }

    /**
     * get all the questionnaires
     * @return
     */
    public List<QuestionnaireDTO> getQuestionnaire(){
        return questionnaireRepository.findAll();
    }

    /**
     * delete questionnaire by id
     * @param id
     * @return
     */
    public String deleteQuestionnaire(final int id){
        if(questionnaireRepository.findById(id).isPresent()){
            questionnaireRepository.deleteById(id);
            return "Delete successfully";
        }else{
            return "Not found";
        }
    }
}