package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.dto.QuestionsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionsDTO, Integer> {
}
