package com.example.QuestionnaireApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuestionnaireApp.model.CodeChallengeQuestionnaire;

public interface CodeChallengeQuestionnaireRepository extends JpaRepository<CodeChallengeQuestionnaire, Integer> {
    
    // List<CodeChallengeQuestionnaire> findQuestionnairesByChallengesId( Long id) ;

    // Iterable<CodeChallengeQuestionnaire> findByTitleContaining(String title);

    //  CodeChallengeQuestionnaire findByIdOrderById( Long id) ;


}
