package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    @Query(
            value = "SELECT * FROM questionnaire WHERE a_class = ?1",
            nativeQuery = true
    )
    List<Questionnaire> findAllByAClass_ClassId(Long classId);
}
