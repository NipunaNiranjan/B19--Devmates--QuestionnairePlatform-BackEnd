package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.SAQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface QuestionBankRepository extends JpaRepository<SAQuestions, Integer> {
    public ArrayList<SAQuestions> findByQuestionnaireId(int id);
}
