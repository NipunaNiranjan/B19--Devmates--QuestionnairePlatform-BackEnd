package com.example.QuestionnaireApp.model;

import javax.persistence.*;

@Entity
@Table(name = "questionnaire_details")
public class QuestionnaireDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int quzId ;
    @Column
    private int challengeId;

    
    public QuestionnaireDetails() {
    }


    public QuestionnaireDetails(int quzId, int challengeId) {
        this.quzId = quzId;
        this.challengeId = challengeId;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getQuzId() {
        return quzId;
    }


    public void setQuzId(int quzId) {
        this.quzId = quzId;
    }


    public int getChallengeId() {
        return challengeId;
    }


    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }


    @Override
    public String toString() {
        return "CodingChallenges [challengeId=" + challengeId + ", id=" + id + ", quzId=" + quzId + "]";
    }

    
   
}
