package com.example.QuestionnaireApp.service;


import com.example.QuestionnaireApp.entity.Question;
import com.example.QuestionnaireApp.entity.TestQuestions;
import com.example.QuestionnaireApp.entity.response.AddTestQuestionResponse;
import com.example.QuestionnaireApp.entity.response.LecturerCreatedQuestionnaire;
import com.example.QuestionnaireApp.entity.response.TestQuestionsResponse;
import com.example.QuestionnaireApp.repository.QuestionRepository;
import com.example.QuestionnaireApp.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LectureService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public AddTestQuestionResponse insertTestQuestions(TestQuestions testQuestions){

        testRepository.save(testQuestions);

        return new AddTestQuestionResponse(testQuestions.getLectureName(),testQuestions.getSubjectName(),testQuestions.getDescription());
    }



    public List<TestQuestionsResponse> getTestQuestions(String subjectName){


        return testRepository.getTestQuestions(subjectName);


    }


    public String deleteQuestionInTest(int  questionID){

        questionRepository.deleteQuestionInTest(questionID);

        return "question is successfully deleted";
    }



    public Question updateQuestionInList(Question questionData){

        questionRepository.updateQuestionInList(questionData.getQuestion(),
                                                questionData.getAnswer1(),
                                                questionData.getAnswer2(),
                                                questionData.getAnswer3(),
                                                questionData.getAnswer4(),
                                                questionData.getCorrectAnswer(),
                                                questionData.getId()
                                                 );
        return questionData;

    }


    public List<LecturerCreatedQuestionnaire> lecturerCreatedQuestionnaires(String lecturerName){

        return testRepository.lecturerCreatedQuestionnaires(lecturerName);
    }







}






