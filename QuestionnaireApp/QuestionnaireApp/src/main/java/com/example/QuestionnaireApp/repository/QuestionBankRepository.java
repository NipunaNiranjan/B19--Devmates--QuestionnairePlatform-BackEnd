package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.SAQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionBankRepository extends JpaRepository<SAQuestion, Long> {
    List<SAQuestion> findByQuestionnaireId(Long id);
}
