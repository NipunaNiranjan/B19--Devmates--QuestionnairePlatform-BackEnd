package com.example.QuestionnaireApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuestionnaireApp.model.CodeChallengeQuestionnaire;
import com.example.QuestionnaireApp.repository.CodeChallengeQuestionnaireRepository;

@Service
public class CodeChallengeQuestionnaireService {
    
@Autowired
private CodeChallengeQuestionnaireRepository questionnaireRepository;

/**
 * save questionnaire
 * 
 * @param data
 * @return
 */
public CodeChallengeQuestionnaire saveQuestionnaire(CodeChallengeQuestionnaire data) {
    return questionnaireRepository.save(data);
}

/**
 * get all the questionnaires
 * 
 * @return
 */
public List<CodeChallengeQuestionnaire> getQuestionnaire() {
    return questionnaireRepository.findAll();
}

public Optional<CodeChallengeQuestionnaire> getQuestionnaireById(int id){
    return questionnaireRepository.findById(id) ;
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
