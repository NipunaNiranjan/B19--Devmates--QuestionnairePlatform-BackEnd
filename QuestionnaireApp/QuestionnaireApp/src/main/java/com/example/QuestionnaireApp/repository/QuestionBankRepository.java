package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.dto.QuestionsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionsDTO, Integer> {
    public ArrayList<QuestionsDTO> findByQuestionnaireId(int id);
}
