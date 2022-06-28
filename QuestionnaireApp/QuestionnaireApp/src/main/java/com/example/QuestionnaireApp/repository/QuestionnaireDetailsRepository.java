package com.example.QuestionnaireApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuestionnaireApp.model.QuestionnaireDetails;

public interface QuestionnaireDetailsRepository extends JpaRepository<QuestionnaireDetails,Integer> {
    
    List<QuestionnaireDetails> getByQuzId( int id);
}
