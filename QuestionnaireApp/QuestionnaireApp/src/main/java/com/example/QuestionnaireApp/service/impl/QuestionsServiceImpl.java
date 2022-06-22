package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.dto.SAQuestionDTO;
import com.example.QuestionnaireApp.model.SAQuestion;
import com.example.QuestionnaireApp.repository.QuestionBankRepository;
import com.example.QuestionnaireApp.service.QuestionsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionBankRepository questionBankRepository;

    public QuestionsServiceImpl(QuestionBankRepository questionBankRepository) {
        this.questionBankRepository = questionBankRepository;
    }

    @Override
    public void saveQuestions(SAQuestion data){
        questionBankRepository.save(data);
    }

    @Override
    public List<SAQuestionDTO> getQuestionByQuestionnaireId(Long id){
        List<SAQuestionDTO> list = new ArrayList<>();
        for(SAQuestion saQuestion: questionBankRepository.findByQuestionnaireId(id)) {
            list.add(
                    SAQuestionDTO
                            .builder()
                            .id(saQuestion.getId())
                            .questionnaireId(saQuestion.getQuestionnaireId())
                            .name(saQuestion.getName())
                            .question(saQuestion.getQuestion())
                            .build()
            );
        }
        return list;
    }

    @Override
    public Optional<SAQuestion> getQuestion(Long id){
        return questionBankRepository.findById(id);
    }

    @Override
    public SAQuestion updateQuestion(Long id, SAQuestion SAQuestion){
        Optional<SAQuestion> questionsDTO1 = questionBankRepository.findById(id);
        questionsDTO1.get().setQuestionnaireId(SAQuestion.getQuestionnaireId());
        questionsDTO1.get().setQuestion(SAQuestion.getQuestion());
        questionsDTO1.get().setName(SAQuestion.getName());
        return questionBankRepository.save(questionsDTO1.get());
    }

    @Override
    public String deleteQuestion(Long id){
        if(questionBankRepository.findById(id).isPresent()){
            questionBankRepository.deleteById(id);
            return "Delete successfully";
        }else{
            return "Not found";
        }
    }
}
