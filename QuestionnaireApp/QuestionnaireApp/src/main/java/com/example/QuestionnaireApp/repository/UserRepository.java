package com.example.QuestionnaireApp.repository;

import java.util.List;

import com.example.QuestionnaireApp.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByTitleContaining(String title);

    List<User> findByPublished(boolean published);
}