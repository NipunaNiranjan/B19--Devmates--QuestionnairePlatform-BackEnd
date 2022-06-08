package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.dto.QuestionnaireDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<QuestionnaireDTO, Integer> {
}
