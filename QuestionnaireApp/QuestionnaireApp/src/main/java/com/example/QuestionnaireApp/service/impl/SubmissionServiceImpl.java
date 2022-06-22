package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.dto.MCQAnswerDTO;
import com.example.QuestionnaireApp.dto.ShortAnswerDTO;
import com.example.QuestionnaireApp.dto.SubmissionDTO;
import com.example.QuestionnaireApp.exception.BadRequestException;
import com.example.QuestionnaireApp.model.*;
import com.example.QuestionnaireApp.repository.SubmissionRepository;
import com.example.QuestionnaireApp.repository.UserRepository;
import com.example.QuestionnaireApp.service.SubmissionService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public void answerQuestionnaire(SubmissionDTO submissionDTO) {
        Date today = new Date();
        if(submissionDTO.getType().equals("MCQ")) {
            for(MCQAnswerDTO mcqAnswerDTO: submissionDTO.getMcqAnswers()) {
                submissionRepository.save(
                        Submission.builder()
                                .student(new User(submissionDTO.getStudentId()))
                                .questionnaire(new Questionnaire(submissionDTO.getQuestionnaireId()))
                                .mcqQuestion(new MCQQuestion(mcqAnswerDTO.getQuestionId()))
                                .mcqOption(mcqAnswerDTO.getOption())
                                .date(today)
                                .build()
                );
            }
        } else if(submissionDTO.getType().equals("SA")) {
            for(ShortAnswerDTO shortAnswerDTO: submissionDTO.getShortAnswers()) {
                submissionRepository.save(
                        Submission.builder()
                                .student(new User(submissionDTO.getStudentId()))
                                .questionnaire(new Questionnaire(submissionDTO.getQuestionnaireId()))
                                .saQuestion(new SAQuestion(shortAnswerDTO.getQuestionId()))
                                .shortAnswer(shortAnswerDTO.getAnswer())
                                .date(today)
                                .build()
                );
            }
        } else {
            throw new BadRequestException("Unknown question type!");
        }
    }
}
