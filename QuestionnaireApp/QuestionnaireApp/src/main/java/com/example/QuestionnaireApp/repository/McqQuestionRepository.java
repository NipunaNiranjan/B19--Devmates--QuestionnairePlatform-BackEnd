package com.example.QuestionnaireApp.repository;


import com.example.QuestionnaireApp.model.McqQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface McqQuestionRepository extends JpaRepository<McqQuestions,Integer> {

    @Query("FROM McqQuestions WHERE questionnaireID = ?1")
    List<McqQuestions> findByQuestionnaireId(int questionnaireID);

}
