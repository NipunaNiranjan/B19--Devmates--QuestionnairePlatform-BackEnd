package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {


    @Modifying
    @Transactional
    @Query("DELETE FROM questions WHERE id = ?1")
    int deleteQuestionInTest(int questionID);




    @Modifying
    @Transactional
    @Query("UPDATE questions SET question = ?1 ,answer1 = ?2,answer2 = ?3,answer3 = ?4,answer4 = ?5,correctAnswer= ?6 " +
            "WHERE id = ?7")
    int updateQuestionInList(String question,String answer1,String answer2, String answer3, String answer4,String correctAnswer,int id);




}
