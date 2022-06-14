package com.example.QuestionnaireApp.controller;


import com.example.QuestionnaireApp.entity.Question;
import com.example.QuestionnaireApp.entity.TestQuestions;
import com.example.QuestionnaireApp.entity.response.AddTestQuestionResponse;
import com.example.QuestionnaireApp.entity.response.LecturerCreatedQuestionnaire;
import com.example.QuestionnaireApp.entity.response.TestQuestionsResponse;
import com.example.QuestionnaireApp.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LectureController {

    @Autowired
    private LectureService lectureService ;


    //   create test
    @PostMapping("/lectures/add_new_tests_questions/")
    public AddTestQuestionResponse addNewTestQuestions(@RequestBody TestQuestions testQuestions) {


        return lectureService.insertTestQuestions(testQuestions);

    }


    //get selected course id test paper
    @GetMapping("/lectures/get_tests_questions/{subjectName}")
    public List<TestQuestionsResponse> getTestQuestions(@PathVariable String subjectName) {

        return lectureService.getTestQuestions(subjectName);
    }


    //delete question in test
    @DeleteMapping("/lectures/delete_tests_question/{questionID}")
    public String deleteQuestionInTest(@PathVariable int questionID) {
        System.out.println(questionID);
        return lectureService.deleteQuestionInTest(questionID);
    }


    //update question in list
    @PatchMapping("/lectures/update_test_question/")
    public Question updateQuestionInList(@RequestBody Question questionData){

        return lectureService.updateQuestionInList(questionData);

    }

    @GetMapping("/lectures/get_lecture_created_questionnaire/{lectureName}")
    public List<LecturerCreatedQuestionnaire> lecturerCreatedQuestionnaires(@PathVariable String lectureName){
        return lectureService.lecturerCreatedQuestionnaires(lectureName);
    }







}
