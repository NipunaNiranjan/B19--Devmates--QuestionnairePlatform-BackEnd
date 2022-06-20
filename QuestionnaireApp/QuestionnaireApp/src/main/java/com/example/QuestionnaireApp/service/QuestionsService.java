package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.model.SAQuestions;
import com.example.QuestionnaireApp.repository.QuestionBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionBankRepository questionBankRepository;

    /**
     * save question
     * @param data
     */
    public void saveQuestions(SAQuestions data){
        questionBankRepository.save(data);
    }

    /**
     * find question by Questionaireid
     * @param id
     * @return
     */
    public ArrayList<SAQuestions> getQuestionByQuestionnaireId(final int id){
        return questionBankRepository.findByQuestionnaireId(id);
    }

    /**
     * find question by id
     * @param id
     * @return
     */

    public Optional<SAQuestions> getQuestion(final int id){
        return questionBankRepository.findById(id);
    }

    /**
     * update question
     * @param id
     * @param SAQuestions
     * @return
     */
    public SAQuestions updateQuestion(final int id, final SAQuestions SAQuestions){

        Optional<SAQuestions> questionsDTO1 = questionBankRepository.findById(id);
        questionsDTO1.get().setQuestionnaireId(SAQuestions.getQuestionnaireId());
        questionsDTO1.get().setQuestion(SAQuestions.getQuestion());
        questionsDTO1.get().setName(SAQuestions.getName());
        //questionsDTO1.get().setType(SAQuestions.getType());

        return questionBankRepository.save(questionsDTO1.get());
    }

    /**
     * delete question by id
     * @param id
     * @return
     */
    public String deleteQuestion(final int id){
        if(questionBankRepository.findById(id).isPresent()){
            questionBankRepository.deleteById(id);
            return "Delete successfully";
        }else{
            return "Not found";
        }
    }
}
