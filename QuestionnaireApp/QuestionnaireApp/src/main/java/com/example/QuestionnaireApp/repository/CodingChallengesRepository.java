package com.example.QuestionnaireApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Repository;

import com.example.QuestionnaireApp.model.CodingChallenges;

@Repository
public interface CodingChallengesRepository extends JpaRepository<CodingChallenges, Integer> {
    
    
    // List<CodingChallenges> findByTitle(String title);


    CodingChallenges findByIdOrderByIdDesc( int id );
    

    
    // List<CodingChallenges> findByPublished(boolean published);

    // @Modifying
    // @Transactional
    // @Query("UPDATE coding_challenges SET challageName = ?1 ,description = ?2,problemStatement= ?3,inputFormat = ?4,constraints = ?5,outputFormat= ?6, published = ?7"
    //         +
    //         "WHERE id = ?8")
    // int updateChallenge(String challageName, String description, String problemStatement, String inputFormat,
    //         String constraints,boolean  published , int id);

    
}
