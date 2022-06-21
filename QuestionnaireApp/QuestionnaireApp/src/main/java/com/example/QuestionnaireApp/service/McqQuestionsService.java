package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.model.McqQuestions;
import com.example.QuestionnaireApp.repository.McqQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class McqQuestionsService {

    @Autowired
    private McqQuestionRepository mcqQuestionRepository;

    public void saveQuestions(McqQuestions data){
        mcqQuestionRepository.save(data);
    }


    public List<McqQuestions> getQuestionByQuestionnaireId(final int id){
        return mcqQuestionRepository.findByQuestionnaireId(id);
    }


    public Optional<McqQuestions> getQuestion(final int id){
        return mcqQuestionRepository.findById(id);
    }

    public McqQuestions updateQuestion(final int id, final McqQuestions mcqQuestions){

        Optional<McqQuestions> question = mcqQuestionRepository.findById(id);
        question.get().setQuestionnaireID(mcqQuestions.getQuestionnaireID());
        question.get().setQuestion(mcqQuestions.getQuestion());
        question.get().setOption1(mcqQuestions.getOption1());
        question.get().setOption2(mcqQuestions.getOption2());
        question.get().setOption3(mcqQuestions.getOption3());
        question.get().setOption4(mcqQuestions.getOption4());
        question.get().setCorrectAnswer((mcqQuestions.getCorrectAnswer()));

        return mcqQuestionRepository.save(question.get());
    }

    public String deleteQuestion(final int id){
        if(mcqQuestionRepository.findById(id).isPresent()){
            mcqQuestionRepository.deleteById(id);
            return "Delete successfully";
        }else{
            return "Not found";
        }
    }
}
