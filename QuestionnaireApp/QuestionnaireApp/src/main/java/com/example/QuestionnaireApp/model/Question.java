package com.example.QuestionnaireApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "question")
public class Question {
    @Id
    private String id;
    @Field
    private String descriptiveName;
    @Field
    private String questionContent;

    public Question(){}

    public Question(String descriptiveName, String questionContent) {
        this.descriptiveName = descriptiveName;
        this.questionContent = questionContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescriptiveName() {
        return descriptiveName;
    }

    public void setDescriptiveName(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Override
    public String toString() {
        return String.format("Question[id='%s' , descriptiveName='%s' , question='%s']", id, descriptiveName, questionContent);
    }
}
