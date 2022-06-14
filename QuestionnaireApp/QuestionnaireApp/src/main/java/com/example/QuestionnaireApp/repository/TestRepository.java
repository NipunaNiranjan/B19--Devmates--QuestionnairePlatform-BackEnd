package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.entity.TestQuestions;
import com.example.QuestionnaireApp.entity.response.LecturerCreatedQuestionnaire;
import com.example.QuestionnaireApp.entity.response.TestQuestionsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TestRepository extends JpaRepository<TestQuestions,Integer> {


    @Query("SELECT new com.example.QuestionnaireApp.entity.response.TestQuestionsResponse(t.questionnaireName,t.questionnaireDuration,q.question,q.answer1," +
            "q.answer2,q.answer3,q.answer4,q.correctAnswer,q.id)FROM test t JOIN t.questionList q WHERE t.subjectName = ?1")
    List<TestQuestionsResponse> getTestQuestions(String subjectName);

    @Query("SELECT new com.example.QuestionnaireApp.entity.response.LecturerCreatedQuestionnaire(questionnaireName,subjectName,description) FROM test WHERE lectureName = ?1")
    List<LecturerCreatedQuestionnaire> lecturerCreatedQuestionnaires(String lecturerName);

}
