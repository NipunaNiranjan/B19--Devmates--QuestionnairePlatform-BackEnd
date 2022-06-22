package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.dto.MCQQuestionDTO;
import com.example.QuestionnaireApp.model.MCQQuestion;
import com.example.QuestionnaireApp.repository.McqQuestionRepository;
import com.example.QuestionnaireApp.service.McqQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class McqQuestionsServiceImpl implements McqQuestionsService {

    @Autowired
    private McqQuestionRepository mcqQuestionRepository;

    public void saveQuestions(MCQQuestion data){
        mcqQuestionRepository.save(data);
    }

    @Override
    public List<MCQQuestionDTO> getQuestionByQuestionnaireId(Long id){
        List<MCQQuestionDTO> list = new ArrayList<>();
        for(MCQQuestion mcqQuestion: mcqQuestionRepository.findAllById(id)) {
            list.add(
                    MCQQuestionDTO
                            .builder()
                            .id(mcqQuestion.getId())
                            .questionnaireID(mcqQuestion.getQuestionnaireID())
                            .question(mcqQuestion.getQuestion())
                            .option1(mcqQuestion.getOption1())
                            .option2(mcqQuestion.getOption2())
                            .option3(mcqQuestion.getOption3())
                            .option4(mcqQuestion.getOption4())
                            .correctAnswer(mcqQuestion.getCorrectAnswer())
                            .build()

            );
        }
        return list;
    }

    @Override
    public MCQQuestion updateQuestion(Long id, MCQQuestion MCQQuestion){
        Optional<MCQQuestion> question = mcqQuestionRepository.findById(id);
        question.get().setQuestionnaireID(MCQQuestion.getQuestionnaireID());
        question.get().setQuestion(MCQQuestion.getQuestion());
        question.get().setOption1(MCQQuestion.getOption1());
        question.get().setOption2(MCQQuestion.getOption2());
        question.get().setOption3(MCQQuestion.getOption3());
        question.get().setOption4(MCQQuestion.getOption4());
        question.get().setCorrectAnswer((MCQQuestion.getCorrectAnswer()));

        return mcqQuestionRepository.save(question.get());
    }

    @Override
    public String deleteQuestion(Long id){
        if(mcqQuestionRepository.findById(id).isPresent()){
            mcqQuestionRepository.deleteById(id);
            return "Delete successfully";
        }else{
            return "Not found";
        }
    }
}
