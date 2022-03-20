package com.example.QuestionnaireApp.repository;

import com.example.QuestionnaireApp.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByDescriptiveName(String descriptiveName);
}

